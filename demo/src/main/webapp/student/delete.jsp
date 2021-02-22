<%--
  Created by IntelliJ IDEA.
  User: Dat Bong
  Date: 2/18/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Delete</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${student.getName()}"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${student.getAge()}"></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value="${student.getCountry()}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete"></td>
        </tr>
    </table>
</form>
</body>
</html>
