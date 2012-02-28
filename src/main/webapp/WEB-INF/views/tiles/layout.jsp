<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<script type="text/javascript" src='<c:url value="/js/jquery-1.6.js"/>'></script>
<script type="text/javascript">
// $(document).ready(function() {
// 	 $(".buttons a").click(function(){
// 		    $(this).addClass('selected'). // <li>
// 		      siblings().removeClass('selected');
// 	  });
// });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<c:set var="css"><spring:theme code="css"/></c:set>
<c:if test="${not empty css}">
	<link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" />
</c:if>

</head>
<body>
	<div id="header">
		<div id="logo">
			<a href="  <c:url value="/category" /> "><img src='<c:url value="/images/mdemo_logo.jpg"/>' alt="IMG" > </a>
		</div>
		<div id="search">
			<form action="">
				<input name="search" type="text">
				<input type="submit" name="search" value="search">
			</form>
		</div>
	</div>
	
	<div id="menuBar">
		<tiles:insertAttribute name="menuBar" />
	</div>
	
	<!-- 
		Notes: If the layout contains an attribute that is not in the definition in the tile XML file
		you will get an attribute not found error. Therefore we use conditional to selectively insert
		attributes.	
	 -->
	<div id="content">
		<div id="side-bars">
			<tiles:insertAttribute name='menu'/>
		</div>
		<div id="mainContent">
			<c:if test="${not empty displayTrail}">
				<div id="trail">
					<tiles:insertAttribute name="trails" />
				</div>
			</c:if>
			<c:if test="${not empty displayPaging}">
				<div id="pagedInfo">
					<tiles:insertAttribute name="pagedInfo" />
				</div>
			</c:if>
			<c:if test="${not empty displaySubs && displaySubs }">
				<div id="resultInfo">
        			<tiles:insertAttribute name='resultInfo'/>
    			</div>
    		</c:if>
    		
    		<div>
        		<tiles:insertAttribute name='content'/>
        	</div>
		</div>
		
    </div>
    <div class="clear">
    </div>
    <div id="footer">
        <tiles:insertAttribute name='footer'/>
    </div>
</body>
</html>