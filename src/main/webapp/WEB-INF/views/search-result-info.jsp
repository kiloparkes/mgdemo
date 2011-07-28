<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.my.mdemo.model.Language"%>


<c:if test="${fn:length(category.children) > 0}">
	</p>Please select a sub-category<p>
	<c:forEach items="${category.children}" var="child" varStatus="idx">
		<c:url value="/category/search" var="curl" scope="page">
			<c:param name="cid" value="${child.id}"/>
		</c:url>
		 <c:forEach items="${child.details}" var="entry">
		 	<c:if test="${entry.key=='en' }">
		 		<a  href="${curl}" > <c:out value="${entry.value.name}"></c:out> </a>
				<c:if test="${ !(idx.index+1 == fn:length(category.children)) }">
					&raquo;
				</c:if>
		 	</c:if>
		 </c:forEach>
		
	</c:forEach>
</c:if>

<br/>