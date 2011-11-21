package com.my.mdemo.web.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.my.mdemo.model.Category;


public class GeneralInterceptor implements HandlerInterceptor {

	public static String CATEGORY_LIST_SESSION_ATTR = "categorylist";
	
	public GeneralInterceptor() {
		System.out.println("");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String servletPath = request.getServletPath();
		if( servletPath.endsWith("/"))
			servletPath = servletPath.substring(0, servletPath.length()-1);
		
		@SuppressWarnings("unchecked")
		List<Category> list = (ArrayList<Category>)request.getSession().getAttribute(CATEGORY_LIST_SESSION_ATTR);
		if( !servletPath.equals("/login.do") && !servletPath.equals("/signUp") &&
				!(servletPath.equals("/category")) && (list == null || list.isEmpty())  )
		{
			/*
			 * The idea was to first redirect to category list where we load the root categories
			 * used in the menu, then in the category list method, redirect to the path passed
			 * in as the value for the url parameter. We will just simply redirect to category
			 * in the event the session expires, because we will have problem with the chain
			 * if we do a search on a leaf category after session expires
			String q = query != null ? query : "";
			String encodedUrl = response.encodeRedirectURL( uri+ "?" + q ) ;
			response.sendRedirect(request.getContextPath() + "/category?url="+encodedUrl);
			*/
	
			response.sendRedirect(request.getContextPath() + "/category");
			
			//NOTE: Returning true would cause the dispatcher to continue to the mapped
			//handler before returning to the browser. 
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	
}
