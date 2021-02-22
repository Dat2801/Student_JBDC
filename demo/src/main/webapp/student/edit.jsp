
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Sửa thông tin học sinh</h1>
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
            <td><input type="submit" value="Chấp nhận"></td>
        </tr>
    </table>
</form>
</body>
</html>
