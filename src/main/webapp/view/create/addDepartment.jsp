<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create new Department</title>
</head>
<body>
<h2>Добавление нового отдела</h2>

<form method="post">
    <label>Название отдела</label><br>
    <input name="name" value="${department.name}"/><br><br>
    <input type="submit" value="Добаить"/>
</form>
</body>
</html>
