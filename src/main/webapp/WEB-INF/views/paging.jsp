<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


	<b>Page:</b>
	<c:if test="${!pagedInfo.navInfo.firstPage}">
		<a href="newcustlist.htm?page=0">First</a>&nbsp;
	</c:if>

	<c:forEach var="i" items="${pagedInfo.navInfo.indexList}">
		<c:choose>
			<c:when test="${i != pagedInfo.navInfo.currentPage}">
				<a href="newcustlist.htm?page=${i}">${i}</a>&nbsp;
			</c:when>
			<c:otherwise>
				<b>${i}</b>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
<br/>