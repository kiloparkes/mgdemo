package com.my.mdemo.web.ctlr;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import com.my.mdemo.web.model.SignUp;


@Controller
@RequestMapping("/signUp*")

public class SignUpController{

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
			@ModelAttribute("signup") @Valid SignUp signup,
			BindingResult result, SessionStatus status
			)
	{
		if( result.hasErrors())
		{
			return "login";
		}
		return "redirect:category";
		
	}
}
