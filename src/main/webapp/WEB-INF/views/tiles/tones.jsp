<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<table>
	<c:forEach items="${pagedInfo.tones}" var="t" varStatus="idx">
		<tr>
			<td>
				<img src='<c:url value="/images/kira.jpg"/>' alt="IMG" >
			</td>
			<td>
				<table>
					<tr>
						<td>
							<c:forEach items="${t.details}" var="entry">
							 	<c:if test="${entry.key=='en' }">
							 		<c:out value="${entry.value.name}"></c:out>
							 	</c:if>
							 </c:forEach>
						 </td>
					</tr>
					<tr>
						<td>
							<c:out value=" $1.00"></c:out>
							&nbsp;
							<a href="#">Buy</a>
						</td>
						
					</tr>
					<tr>
						<td>
							<p>
							Consumer confidence in the U.S. fell last week for the first time in a month. 
							The Bloomberg Consumer Comfort Index decreased to minus 45.1 in the period ended 
							April 24, the lowest level since the end of March, from minus 42.6. Measures of 
							personal finances and buying climate dropped.
							</p>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</c:forEach>
</table>


<p >
	"It's already a credit-starved economy; we know that. That's the chief complaint, that banks are not lending out there. You're just giving banks another reason to not lend there," Farzad said on "The Early Show." "If they can't take for granted the government is good for its obligations, if they don't see past August 2nd, if there's no visibility, everything stops."
</p>