<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<form:form modelAttribute="course">  

Course_Id: ${course.id}<br/>
Course Name : ${course.name }<br/>
Code : <form:input path="code"/><br/>
Unit : <form:input path="units"/><br/>

<input type="submit" value="Save" name="save" /><br/>
</form:form>

</body>
</html>