package com.my.mdemo.web.ctlr;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.my.mdemo.model.Users;
import com.my.mdemo.service.UserService;
import com.my.mdemo.web.model.SignUp;


@Controller
@RequestMapping("/signUp*")

public class SignUpController{

	public UserService userService; 
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
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
		
		Users user = new Users();
		
		if( userService.getUser(signup.getUsername() )== null)
			userService.addUser(user);
		else
			return "login";
		
		return "redirect:category";
		
	}
}
