<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OnCourse - Courses</title>
</head>
<body>
<h2><a href="../index.html">OnCourse</a></h2>
<h3>Courses</h3>
<table border="1">
<tr><th>Code</th><th>Name</th><th>Units</th></tr>
<c:forEach items="${courses}" var="course">
<tr>
  <td>${course.code}</td>
  <td>${course.name}</td>
  <td style="text-align: center;">${course.units}</td>
  <td><a href="edit.html?id=${course.id}">Edit</a></td>
  <td><a href="delete.html?id=${course.id}">Edit</a></td>
</tr>
</c:forEach>
<a href="add.html">Add New Course</a>
</table>
</body>
</html>
