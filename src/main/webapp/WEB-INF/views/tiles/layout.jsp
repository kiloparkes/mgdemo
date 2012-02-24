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
	<div id="heading">
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
	
	<div id="content">
		<div id="side-bars">
			<tiles:insertAttribute name='menu'/>
		</div>
		<div id="mainContent">
				<div id="pagedInfo">
					<tiles:insertAttribute name="pagedInfo" />
				</div>
				<div id="resultInfo">
        			<tiles:insertAttribute name='resultInfo'/>
    			</div>
        	<tiles:insertAttribute name='content'/>
        </div>
    </div>
    <div id="footer">
        <tiles:insertAttribute name='footer'/>
    </div>
</body>
</html>