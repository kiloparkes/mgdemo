package com.my.mdemo.web.ctlr;

import java.util.HashMap;
import java.util.Map;

import com.my.mdemo.model.Tone;
import com.my.mdemo.web.util.PagedView;

public class ToneController {

	void search(){
		

//		protected ModelAndView handleRequestInternal(HttpServletRequest request,
//		HttpServletResponse response) throws Exception {

			
		Map<Object, Object> model = new HashMap<Object, Object>();
		
		PagedView<Tone> pcustv = new PagedView<Tone>();
		
		 
		
		//pcustv.getNavInfo().setRowCount(custRegService.getUnauthorizedCustomerCount());
		
		 
		
//		String page = (String)request.getParameter("page");
//		if (null == page)
//		
//		pcustv.getNavInfo().setCurrentPage(0);
//		
//		else
//		
//		pcustv.getNavInfo().setCurrentPage(Integer.parseInt(page));
		
		 
		
//		pcustv.setCustomers(custRegService.getUnauthorizedCustomers(
//		
//				pcustv.getNavInfo().getCurrentPage(), pcustv.getNavInfo().getPageSize()));
//		
		 
		
		//request.getSession().setAttribute("pagedcust", pcustv);
		
		model.put("pagedcust", pcustv);
		 
		
		//return new ModelAndView("admin/newcustlist", model);

	}
}
