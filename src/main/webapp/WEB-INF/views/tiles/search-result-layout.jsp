<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src='<c:url value="/js/jquery-1.6.js"/>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<c:set var="css"><spring:theme code="css"/></c:set>
<c:if test="${not empty css}">
	<link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" />
</c:if>


<body>
	<div id="top">
		<div class="logo">
			<a href="  <c:url value="/category" /> "><img src='<c:url value="/images/mdemo_logo.jpg"/>' alt="IMG" > </a>
		</div>
		<div class="search">
			<form action="">
				<input name="search" type="text">
				<input type="submit" name="search" value="search">
			</form>
		</div>
	</div>
	
	<div id="menuBar">
		<tiles:insertAttribute name="menuBar" />
	</div>
	<div id="menu">
        <tiles:insertAttribute name='menu'/>
    </div>
    <div id="tbody">
		<div id="heading">
			<tiles:insertAttribute name="heading" />
		</div>
		<c:if test="${!empty pagedInfo }">
			<div id="pagedInfo">
				<tiles:insertAttribute name="pagedInfo" />
			</div>
		</c:if>
		 <div id="resultInfo">
        	<tiles:insertAttribute name='resultInfo'/>
    	</div>
		<div id="content">
        	<tiles:insertAttribute name='content'/>
    	</div>
	</div>
	
     <div id="footer">
        <tiles:insertAttribute name='footer'/>
    </div>
</body>
</html>