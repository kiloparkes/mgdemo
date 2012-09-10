<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<ul class="ul">
<c:forEach items="${pagedInfo.items}" var="cat" >
		<c:url value="/category/search" var="curl">
			<c:param name="cid" value="${cat.id}"/>
		</c:url>
		<li>
			<a href="${curl}" > <c:out value="${cat.displayName}"></c:out> </a>
		</li>
<br></br>
</c:forEach>
</ul>