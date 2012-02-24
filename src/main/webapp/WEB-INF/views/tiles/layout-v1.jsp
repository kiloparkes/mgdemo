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
		<!--  
		<div class"preview">
			<audio src='<c:url value="/audios/four.wav"/>' controls="controls">
			</audio>
		</div>
		-->
	</div>
	<div id="menuBar">
		<tiles:insertAttribute name="menuBar" />
	</div>
	<div id="menu">
        <tiles:insertAttribute name='menu'/>
    </div><!--END: Menu-->
    <div id="content">
        <tiles:insertAttribute name='content'/>
    </div>
     <div id="footer">
        <tiles:insertAttribute name='footer'/>
    </div>
</body>
</html>