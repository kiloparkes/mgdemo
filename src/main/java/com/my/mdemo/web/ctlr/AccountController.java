package com.my.mdemo.web.ctlr;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/account*")
public class AccountController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String show(Model model){
		Date today = new java.util.Date();
		model.addAttribute("today", today);
		
		return "account";
	}

}
