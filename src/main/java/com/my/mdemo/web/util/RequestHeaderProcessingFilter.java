package com.my.mdemo.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/*
 * This servlet filter that is responsible for translating the request headers 
 * into our SignedMsisdnAuthenticationToken
 */
public class RequestHeaderProcessingFilter extends AbstractAuthenticationProcessingFilter {

	private String usernameHeader = "j_msisdn";
	private String signatureHeader = "j_id";
	
	protected RequestHeaderProcessingFilter() {
		super("/singleSignOn");
	}
	
	//The doFilter() method is implemented by the base Filter Class
	//which then calls attemptAuthentication to get the token
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		
		String msisdn = request.getHeader(usernameHeader);
		String signature = request.getHeader(signatureHeader);
		
		// raise error of all expected headers are not present
		SignedMsisdnAuthenticationToken authRequest = 
			new SignedMsisdnAuthenticationToken(msisdn, signature);
		
		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		String uri = request.getRequestURI();
		
		if(uri.indexOf(getFilterProcessesUrl()) > 0)
			return true;
		else
			return false;
	}
}
