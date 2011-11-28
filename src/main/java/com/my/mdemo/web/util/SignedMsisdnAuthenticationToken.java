package com.my.mdemo.web.util;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


/*
 * Notes:
 * The purpose of tokens is to encapsulate presented credentials for later verification.
 */

@SuppressWarnings("serial")
public class SignedMsisdnAuthenticationToken extends AbstractAuthenticationToken {

	
	/*
	This class is used for SSO authentication where the check an Md5 hashed string
	sent in the header. The other data in the header will be used to re-generate 
	the MD5 hash for verification
	 */
	
	/*
	The principal will be the msisdn found in the header
	The credentials will be the value of the j_id parameter. This is an MD5 hash
	of request parameters, plus a timestamp assumed to be sometime within the last
	minute. To simply thinks, we will simple use plain text for j_id 
	 */

	 private final Object principal;
	 private Object credentials;

	public SignedMsisdnAuthenticationToken(Object principal, Object credentials) {
		super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
	}

	public SignedMsisdnAuthenticationToken(Object principal, Object credentials, boolean authenticated, Collection<? extends GrantedAuthority> authorities) {
		
		super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(authenticated);
	}
	
	@Override
	public Object getCredentials() {
		return credentials;
	}


	@Override
	public Object getPrincipal() {
		return principal;
	}

}
