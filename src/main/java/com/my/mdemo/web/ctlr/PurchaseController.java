package com.my.mdemo.web.ctlr;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.mdemo.model.Basket;
import com.my.mdemo.model.ItemWrapper;
import com.my.mdemo.model.Tone;
import com.my.mdemo.web.util.PagedView;


@Controller
@RequestMapping("/purchase/*")
@SessionAttributes("basket")

public class PurchaseController {
	
	/**
	 * Note that session access may not be thread-safe, in particular in a Servlet 
	 * environment: Consider switching the "synchronizeOnSession" flag to "true" if
	 *  multiple requests are allowed to access a session concurrently. 
	 */
	
	@RequestMapping(value = "addToBasket" , method = RequestMethod.GET)
	/* {userId} denoted a URI template variable, used in conjunction with the PathVariable*/
	public String addToBasket(HttpServletRequest hsrq 
			,HttpServletResponse hsrs
			,HttpSession sess
			, Locale locale
			, Reader reader
			, Writer writer
			//, @PathVariable Integer userId
			/* Whatever comes after /purchase in the URI will be bound to the variable named userId*/
			/* This will only work if the code is compiled with debugging enabled*/
			/* If not, you must specify the URI template variable when declaring the path variable as follows*/
			//, @PathVariable("userId") Integer uId
			, @RequestParam Integer index
			, @RequestParam Map<String, String> params
			//, @RequestHeader String  acceptHeader
			, Model model
			//, ModelAttribute formData
			,@ModelAttribute("pagedInfo") PagedView<Tone> tones
			)
	{
		
		PagedView<Tone> tonePage = (PagedView<Tone>)sess.getAttribute("pagedInfo");
		 Basket basket = (Basket)model.asMap().get("basket");
		 if(basket== null)
			 basket = new Basket();

		Tone tone = (Tone)tonePage.getItem(index);
		ItemWrapper iw = new ItemWrapper(tone);
		basket.addItem(iw);
		
		model.addAttribute("current_item", iw);
		model.addAttribute("basket", basket);
		return "basket";
	}

}
