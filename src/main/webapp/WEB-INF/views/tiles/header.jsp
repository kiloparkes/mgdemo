<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% String contextPath = request.getContextPath(); %>

	<div class="login">
	<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
		Please  <a href='<c:url value="login.do"></c:url>'>login </a>
               
    </sec:authorize>
   <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
         <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
   </sec:authorize>
	
	</div>
	<div class="account">
			<a href="<c:url value="/account"/>">My Account</a>
	</div>
