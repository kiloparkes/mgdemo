package com.my.mdemo.web.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

// *** Use the filter to ensure admin users can only login from certain IP
// This should be placed after the user has been authenticated in the filter chain
//
public class IPRoleAuthenticationFilter extends OncePerRequestFilter{

	private String targetRole = "ROLE_ADMIN";
	private List<String> allowedIPAddresses;

	
	
	public void setTargetRole(String targetRole) {
		this.targetRole = targetRole;
	}



	public void setAllowedIPAddresses(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain chain)
	throws ServletException, IOException {

		final Authentication authentication = SecurityContextHolder.
		getContext().getAuthentication();


		if (authentication != null && targetRole != null) {
			boolean shouldCheck = false;
			// look if the user is the target role
			for (GrantedAuthority authority : authentication.
					getAuthorities()) {
				if(authority.getAuthority().equals(targetRole)) {
					shouldCheck = true;
					break;
				}
			}
		
			// if we should check IP, then check
			if(shouldCheck && allowedIPAddresses.size() > 0) {
				boolean shouldAllow = false;
				for (String ipAddress : allowedIPAddresses) {
					if(req.getRemoteAddr().equals(ipAddress)) {
						shouldAllow = true;
						break;
					}
				}
				
				
				if(!shouldAllow) {
					// fail the request
					throw new AccessDeniedException("Access has been denied for your IP address: "+req.getRemoteAddr());
				}
			}	
		}
		else {
			logger.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");
		}
		
		chain.doFilter(req, res);
	}
}
