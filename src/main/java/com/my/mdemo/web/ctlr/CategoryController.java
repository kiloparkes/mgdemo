package com.my.mdemo.web.ctlr;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.mdemo.model.Category;
import com.my.mdemo.model.Tone;
import com.my.mdemo.service.CategoryService;
import com.my.mdemo.service.ToneService;
import com.my.mdemo.web.util.PagedView;

@Controller
@SessionAttributes({"categorylist", "chain", "root", "pagedInfo"})
public class CategoryController {
	
	public CategoryService categoryService;
	
	public ToneService toneService;
	
	
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Autowired
	public void setToneService(ToneService toneService) {
		this.toneService = toneService;
	}


	@RequestMapping( value="/category", method = RequestMethod.GET)
	//the controller’s default HTTP GET handler method.
	public String list( HttpServletRequest request, HttpServletResponse response, Model model){
		
		model.addAttribute("root", new Category());
//		String redirectUrl = (String)request.getParameter("url");
		model.addAttribute("categorylist",categoryService.getCategories());

//		if( redirectUrl != null) {
//			String urlWithSessionID = response.encodeRedirectURL(redirectUrl);
//			try {
//				response.sendRedirect( urlWithSessionID);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	
		
		return "categories";
	}

	@RequestMapping("create")
	void create(Model model){
		model.addAttribute("category", new String());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value="/category/search", method=RequestMethod.GET)
	public String search(@RequestParam("cid") int id, Model model, HttpServletRequest request){
		
		String view = "categoryResult";
		boolean displayPaging = false;
		boolean displaySubs = true;
		
		Category c = categoryService.getCategory(id);
		if(c!= null && c.getChildrenCount() == 0)
		{
			// This is a leaf category... Only leaf categories can contain tones
			PagedView<Tone> p = new PagedView<Tone>("/category/search");
			int cnt = toneService.getTonesOfCategoryCount(id);
			
			
			p.getNavInfo().setRowCount(cnt);
			String page = (String)request.getParameter("page");
			if (null == page){
				p.getNavInfo().setCurrentPage(1);
			}
			else{
				p.getNavInfo().setCurrentPage(Integer.parseInt(page));
			}
			
			List<Tone> tl = toneService.getTonesOfCategory(id, 
					p.getNavInfo().getPageSize(), p.getNavInfo().getCurrentPage()-1);
			p.setItems(tl);
			
			model.addAttribute("pagedInfo", p);
			view = "toneResult";
			
			displayPaging = true;
			displaySubs = false;
			model.addAttribute("displayPaging", displayPaging);
		}
		
		model.addAttribute("category", c);		
		model.addAttribute("displayTrail", true);
		model.addAttribute("displaySubs", displaySubs);
		
		
		prepareTrail(c, model);
		
		return view;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping( value="/category/more", method=RequestMethod.GET)
	public String more(
				@RequestParam("cid") int id,
				@RequestParam("page") Integer page,
				Model model, 
				HttpServletRequest request){
		
		boolean isPaging = true;
		
		Category c = categoryService.getCategory(id);
		int cnt = categoryService.getSubCategoriesCount(id);
		
		PagedView<Category> p = new PagedView<Category>("/category/more");
		p.getNavInfo().setPageSize(5);
		
		p.getNavInfo().setRowCount(cnt);
		
		if (null == page){
			p.getNavInfo().setCurrentPage(1);
		}
		else{
			p.getNavInfo().setCurrentPage(page);
		}
		
		int firstResult = (p.getNavInfo().getCurrentPage()-1)*p.getNavInfo().getPageSize();
		int maxResults = p.getNavInfo().getPageSize();
		List<Category> subCategories = 
			categoryService.getSubCategories(id, firstResult, maxResults);
		
		p.setItems(subCategories);
		
		model.addAttribute("displayPaging", isPaging);
		model.addAttribute("category", c);
		model.addAttribute("pagedInfo", p);
		model.addAttribute("displayTrail", true);
		return "categoriesPage";
	}
	
	@SuppressWarnings("unchecked")
	private void prepareTrail(Category c, Model model){
		
		//---
		LinkedList<Category> chain = null;
		Map<String, Object> map = model.asMap();
		if (model.containsAttribute("chain") )
				chain = (LinkedList<Category>)map.get("chain");
		else
			chain = new LinkedList<Category>();
	
		// either the current category is a child of the last category or it is a sibling
		// if child add to list else replace last with current
		
		if(c.getParent() == null) { // root
			model.addAttribute("root", c);
			chain.clear();
			chain.add(c);
		}
		else {
			if (chain.contains(c) )
			{
				// zero based index
				int x = chain.indexOf(c);
				while(chain.size()>x+1){
					// c should now be the last in the trail so remove all that come after
					chain.removeLast();
				}
			}
			else
			{
				if(c.getParent().getId().intValue() ==  chain.getLast().getId().intValue()) 
					chain.add(c); // child of end category
				else { // sibling
					chain.removeLast();
					chain.add(c);
				}
			}
		}
			
		model.addAttribute("chain", chain);
	}
}
