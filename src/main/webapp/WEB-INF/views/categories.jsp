<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="l-side-bar">
<h2>Browse Categories</h2>
<br/>
	

<c:forEach items="${categorylist}" var="cat" >
		<c:url value="/category/search" var="curl">
			<c:param name="cid" value="${cat.id}"/>
		</c:url>
		<c:choose>
			<c:when test="${! empty root && (root.id==cat.id)}">
				<c:set var="cls">style="color:#000000;font-weight:bolder"</c:set>
				<!-- NOTE:overriding the color property of the link was not possible using the 'selected' style defined in the css file. -->
			</c:when>
			<c:otherwise>
				<c:set var="cls">button</c:set>
			</c:otherwise>
		</c:choose>
		
		<a ${cls} href="${curl}" > <c:out value="${cat.displayName}"></c:out> </a>
<br></br>
</c:forEach>

<h3>Top Sellers</h3>
<c:forEach items="${categorylist}" var="cat" >
		<a href="#"> <c:out value="${cat.displayName}"></c:out> </a>
<br></br>
</c:forEach>

<h3>Genres</h3>
<c:forEach items="${categorylist}" var="cat" >
		<a href="#"> <c:out value="${cat.displayName}"></c:out> </a>
<br></br>
</c:forEach>

<h3>Latest Releases</h3>
<c:forEach items="${categorylist}" var="cat" >
		<a href="#"> <c:out value="${cat.displayName}"></c:out> </a>
<br></br>
</c:forEach>

</div>


<div id="r-side-bar">
	<h3>Most Popular</h3>
	<c:forEach items="${categorylist}" var="cat" >
		<a href="#"> <c:out value="${cat.displayName}"></c:out> </a>
	<br></br>
</c:forEach>
</div>