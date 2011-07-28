<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% String contextPath = request.getContextPath(); %>

	<div class="login">
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		<!-- NOTE: On Context relative (with leading slash) and page relative paths
			When the servletpath = /category, the page relative URI is converted 
			to ../mdemo/login.do 
			When the servletpath = /category/search, the page relative URI is 
			converted to ../mdemo/category/login.do.
			Context relative URI is always relative to he context. In this case ../mdmo
			Therefore, "/login.do" will always be converted to /mdemo/login.do
			
			NB: The servletpah is any of path in RequestMapping annotation
			of the controllers
		-->
		Please  <a href='<c:url value="/login.do"></c:url>'>login </a>
               
    </sec:authorize>
   <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
         <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
   </sec:authorize>
	
	</div>
	<div class="account">
			<a href="#">My Account</a>
	</div>