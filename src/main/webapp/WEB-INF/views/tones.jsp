<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.my.mdemo.model.Language"%>


<h2>The Browsing JSP</h2>



The Model and Controller codes are done. Now you write the view –
<strong>newcustlist.jsp</strong>
. Create it by copying admin.jsp as usual. Following is the relevant
additions you need to write:

<blockquote>



	<div id="content">

		<div align="center">

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
<c:if test="${!pagedInfo.navInfo.lastPage}">
	<!-- 
	<a href="newcustlist.htm?page=${pagedInfo.navInfo.pageCount – 1}">Last</a>
	-->
</c:if>


</div>

		<form action="<%=request.getContextPath()%>/authorizecust.htm"
			method="post">

			<table>

				<thead>

					<tr>

						<td>User ID</td>

						<td>First Name</td>

						<td>Last Name</td>

						<td>Email</td>

					</tr>

				</thead>

				<tbody>

					<c:forEach var="cust" items="${pagedcust.customers}">

						<tr>

							<td>${cust.userId}</td>

							<td>${cust.firstName}</td>

							<td>${cust.lastName}</td>

							<td>${cust.email}</td>

							<td><input type="checkbox" value="${cust.id}"
								name="authorized" />
							</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

			<input type="hidden" name="linkBackIndex"
				value="${pagedcust.navInfo.currentPage}" /> <input type="submit"
				value="Authorize" />

		</form>

	</div>
</blockquote>


<br />