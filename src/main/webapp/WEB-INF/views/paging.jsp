<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


	<b>Page:</b>
	<!-- 
	<c:if test="${!pagedInfo.navInfo.firstPage}">
		<a href="newcustlist.htm?page=0">First</a>&nbsp;
	</c:if>
	 -->
	<!-- NOTE: What happens when paging applies to a form page ... would curl work -->
	<c:forEach var="i" items="${pagedInfo.navInfo.indexList}">
		<c:choose>
			<c:when test="${i != pagedInfo.navInfo.currentPage}">
				<c:url value="/category/search" var="curl">
					<c:param name="cid" value="${category.id}"/>
					<c:param name="page" value="${i}"/>
				</c:url>
				<a href="${curl}">${i}</a>
				&nbsp;
			</c:when>
			<c:otherwise>
				<b>${i}</b>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
<br/>