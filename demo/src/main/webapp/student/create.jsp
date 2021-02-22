<%--
  Created by IntelliJ IDEA.
  User: Dat Bong
  Date: 2/18/2021
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Create</title>
</head>
<body>
<h1>Thêm học sinh mới</h1>
<form method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" placeholder="nhập id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="nhập tên"></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age" placeholder="nhập tuổi"></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" name="country" placeholder="nhập quê quán"></td>
        </tr>
        <tr>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
