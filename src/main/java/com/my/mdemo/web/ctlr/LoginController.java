package com.my.mdemo.web.ctlr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.mdemo.web.model.SignUp;


@Controller
@RequestMapping("/login*")
@SessionAttributes("signup")
/*
 * Use SessionAttributes to avoid losing whatever valid data was already
   provided by a user on every subsequent submission, in the event of errors after
   the user submits the form
 */
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void show(Model model){
		SignUp signup = new SignUp();
		model.addAttribute("signup", signup);
	}

}
