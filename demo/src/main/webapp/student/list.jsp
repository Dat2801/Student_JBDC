<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<%--<form action="/product">--%>
<%--    <input value="search" name="action" hidden>--%>
<%--    <input type="text" name="name" placeholder="nhập tên" >--%>
<%--    <input type="submit" value="tìm kiếm">--%>
<%--</form>--%>
<h1>Danh sách học sinh</h1>
<button><a href="/student?action=create">Create new student</a></button>
<table>
    <tr>
        <td>Name</td>
        <td>Age</td>
        <td>Country</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${s}" var="student">
        <tr>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getCountry()}</td>
            <td><a href="/student?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="/student?action=delete&id=${student.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
