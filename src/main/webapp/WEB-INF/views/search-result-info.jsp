<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.my.mdemo.model.Language"%>

<c:set var="maxCategories" value="2"/>
<c:if test="${fn:length(category.children) > 0}">
	</p>Please select a sub-category<p>
	<c:forEach items="${category.children}" var="child" varStatus="idx" end="${maxCategories-1}">
		<c:url value="/category/search" var="curl" scope="page">
			<c:param name="cid" value="${child.id}"/>
		</c:url>
		 <c:forEach items="${child.details}" var="entry">
		 	<c:if test="${entry.key=='en' }">
		 		<a  href="${curl}" > <c:out value="${entry.value.name}"></c:out> </a>
				<c:if test="${ !(idx.index+1 == fn:length(category.children)) && !(idx.index == maxCategories-1)}">
					&raquo;
				</c:if>
		 	</c:if>
		 </c:forEach>
	</c:forEach>
	<c:if test="${fn:length(category.children) > maxCategories }">
		<c:url value="/category/more" var="curl" scope="page">
			<c:param name="cid" value="${category.id}"/>
			<c:param name="page" value="1"/>
		</c:url>
		<a href="${curl}">
		 	&raquo; <c:out value="More..."></c:out>
		 </a>
	</c:if>
</c:if>

<br/>