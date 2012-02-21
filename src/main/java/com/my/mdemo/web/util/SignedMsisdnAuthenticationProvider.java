package com.my.mdemo.web.util;

import java.util.Arrays;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.GrantedAuthorityImpl;


public class SignedMsisdnAuthenticationProvider implements AuthenticationProvider {
	
	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		SignedMsisdnAuthenticationToken successAuth = null;
		if(vaidate(authentication)) {
			//NOTE:To test access denied change the role to an unknown role like ROLE_GUEST
			GrantedAuthorityImpl[] authList = {new GrantedAuthorityImpl("ROLE_GUEST")};
			// create new authenticated token -- where authenticated is set to true
			successAuth = 
				new SignedMsisdnAuthenticationToken(authentication.getPrincipal(), 
						authentication.getCredentials(), true, Arrays.asList(authList));
		}
		else
			throw new BadCredentialsException(messages.getMessage(
                    "SignedMsisdnAuthenticationProvider.badCredentials", "Bad credentials"));
		
		return successAuth;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return SignedMsisdnAuthenticationToken.class.isAssignableFrom(authentication);
	}

	
	private boolean vaidate(Authentication authentication){
		
		if( ((String)authentication.getCredentials()).equalsIgnoreCase(authentication.getName()))
			return true;
		else 
			return false;
	}
	
}
