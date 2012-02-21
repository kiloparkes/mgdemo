package com.my.mdemo.web.ctlr;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.mdemo.web.model.SignUp;


@Controller
//@RequestMapping("/login*")
@SessionAttributes("signup")
/*
 * Use SessionAttributes to avoid losing whatever valid data was already
   provided by a user on every subsequent submission, in the event of errors after
   the user submits the form
 */
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET, value="/accessDenied*")
	public void accessDenied(ModelMap model,
			HttpServletRequest request) {
		AccessDeniedException ex = (AccessDeniedException)
		request.getAttribute(AccessDeniedHandlerImpl.SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY);
		StringWriter sw = new StringWriter();
		model.addAttribute("errorDetails", ex.getMessage());
		ex.printStackTrace(new PrintWriter(sw));
		model.addAttribute("errorTrace", "");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/login*")
	public void show(Model model){
		SignUp signup = new SignUp();
		model.addAttribute("signup", signup);
	}
	
	

}
