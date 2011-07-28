<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<h2>
<c:if test="${fn:length(chain) > 0}">
	<c:forEach items="${chain}" var="cat" varStatus="idx">
		<c:url value="/category/search" var="curl">
			<c:param name="cid" value="${cat.id}"/>
		</c:url>
		<c:forEach items="${cat.details}" var="entry">
		 	<c:if test="${entry.key=='en' }">
		 		<a  href="${curl}" > <c:out value="${entry.value.name}"></c:out> </a>
				<c:if test="${ !(idx.index+1 == fn:length(chain)) }">
					&raquo;
				</c:if>
		 	</c:if>
		 </c:forEach>
			
	</c:forEach>
</c:if>
<br/>
</h2>