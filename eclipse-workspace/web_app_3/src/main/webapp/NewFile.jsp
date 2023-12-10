<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "xx" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Learn</title>
</head>
<body>
	<xx:out value="Hello"></xx:out>
	
	<xx:set var="name" value="sumit"></xx:set>
	<xx:out value="${name}"></xx:out>
	
	<xx:set var = "salary" scope = "session" value = "${2000*20}"/>
      <xx:if test = "${salary > 2000}">
         <p>My salary is:  <xx:out value = "${salary}"/><p>
    </xx:if>
    
    
    <xx:forEach var = "i" begin = "1" end = "5">
         <p>Item <xx:out value = "${i}"/><p>
    </xx:forEach>
</body>
</html>