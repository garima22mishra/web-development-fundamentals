<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>c:out demo</title>
</head>
<body>
	<c:out value="${10+9}"></c:out><br/>
	<c:set var="testScore" scope="session" value="${60}" /><br/>
	<c:out value="${testScore}" /><br/>
	<c:if test="${testScore >= 80 }">
		<p>Your score is awesome </p>
		<c:out value="${testScore }"/><br/>
	</c:if>
	
	<c:choose>
	<c:when test="${testScore >=80 }" >
		<p>Your grade is A : </p><c:out value="${testScore }"></c:out><br/>
	</c:when>
	
	<c:when test="${testScore >50 }" >
		<p>Your grade is B : </p><c:out value="${testScore }"></c:out><br/>
	</c:when>
	
	<c:otherwise>
		<p>Your grade is C.</p>
	</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="1" end="5">
		<c:out value="${i }"></c:out><br/>
	</c:forEach>
	
	<%
		List<String> students = new ArrayList<String>();
		students.add("Avril");
		students.add("Bob");
		students.add("Carl");
		students.add("Douglas");
		students.add("Eden");
		
		request.setAttribute("students", students);
	%>
	
	<c:forEach var="student" items="${students}">
		<c:out value="${student }"></c:out><br/>
	</c:forEach>
	<c:remove var="testScore"/><br/>
	After removal value is:<c:out value="${testScore }" /><br/>
</body>
</html>