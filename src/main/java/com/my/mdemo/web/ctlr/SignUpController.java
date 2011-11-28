package com.my.mdemo.web.ctlr;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.my.mdemo.model.Authorities;
import com.my.mdemo.model.Users;
import com.my.mdemo.service.UserService;
import com.my.mdemo.web.model.SignUp;


@Controller
@RequestMapping("/signUp*")

public class SignUpController{
	/*
	 * NOTES:
	 * Validation of model is done via annotation
	 */
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
		user.setPassword(signup.getPassword());
		user.setUsername(signup.getUsername());
		user.setEnabled(true);
		
		@SuppressWarnings("unused")
		Set<Authorities> auset = new HashSet<Authorities>();
		Authorities auth = new Authorities();
		auth.setAuthority("ROLE_USER");
		auth.setUsername(signup.getUsername());
		/*
		auth.setUsers(user);
		auset.add(auth); // or user.getAuthorities().add(auth);
		
		//Note: Must set the collection on the holding entity in order for the collection
		//to be save automatically when the holding entity is saved.
		user.setAuthorities(auset);
		
		*/
		//Note: Using the addAuthority convenience method instead of the three calls above
		user.addAuthority(auth);
		
		try {
			userService.addUser(user);
		}
		catch (Exception e) {
			// TODO: handle exception
			result.rejectValue("username", "error.username.not.available", "Username not available!");
			return "login";
		}
		
		return "redirect:category";
		
	}
}
