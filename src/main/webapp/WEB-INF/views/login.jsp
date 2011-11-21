<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Login</title>
<style type="text/css" media="screen">
		.error {
		color: #ff0000;
		font-weight: bold;
		font-size: 10px;
		font-family: sans-serif;
		font-style: italic;
		}
		body
		{
			margin: 20px;
			padding: 0;
			font: normal 85% arial, helvetica, sans-serif;
			color: #000;
			background-color: #fff;
		}
		
		.label {
			font-size: 11px;
			font-weight: bolder;
			font-family: sans-serif;
		}
		
		.button {
			font-size: 11px;
			font-weight: bold;
			font-family: sans-serif;
		}
		
		.containingbox
		{
			margin-top:30px;
			width: 800px;
			height: 300px;
			border: 1px solid #000;
		}
		
		.floatright
		{
			float: right;
			width: 100px;
			height: 100px;
			background-color: #F63;
		}
		
		.lside
		{
			float: left;
			width: 400px;
			border-right-style: groove;
			height: 300px;
		}
		
		.lheader
		{
			height: 20px;
			background-color: #F63;
			font-family: sans-serif;
			font-size: 15px;
			font-weight:bolder;
			text-align: center;
		}
</style>
</head>
<body>
	<!-- 
		Session attribute
		SPRING_SECURITY_LAST_EXCEPTION stores the last exception for the current user.
	 -->
	<c:if test="${not empty param.error}">
	<div>
		<font color="red">
			Login error. <br />
			Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	</div>
	</c:if>

<div class="containingbox">
	<div class="lside">
		<div class="lheader">
			Log on...
		</div>
		<form method="POST" action="<c:url value="/j_spring_security_check" />">
		<table>
		<tr>
		<td align="right" class="label">Username</td>
		<td><input type="text" name="j_username" /></td>
		</tr>
		<tr>
		<td align="right" class="label">Password</td>
		<td><input type="password" name="j_password" /></td>
		</tr>
		<tr>
		<td align="right" class="label">Remember Me?</td>
		<td>
			<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/>
		</td>
		</tr>
		<tr>
		<td colspan="2" align="right">
		<input type="submit" value="Login" class="button"/>
		<input type="reset" value="Reset" class="button"/>
		</td>
		</tr>
		</table>
		</form>
	</div>
	<div class="lheader">
		Sign Up...
	</div>

	<c:url var="u" value="/signUp"></c:url>
	<div>
		<form:form method="POST" action="${u}" modelAttribute="signup">
			<%-- This means that upon rendering the view, the form 
			expects an object named signup to be available, --%>
			
			<%-- the path values for each form-input tag corresponds to the field
				names belonging to the SignUp object --%>
			  
			  <!-- 
			<form:errors path="*" cssClass="error" />  -->
			<table>
				<tr>
					<td align="right" class="label">Username</td>
					<td><form:input path="username"  maxlength="20"/></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="right" class="label">Password</td>
					<td><form:input type="password" path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td align="right" class="label">Email Address</td>
					<td><form:input type="text" path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<input type="submit" value="SignUp" class="button"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>

</div>
</body>
</html>