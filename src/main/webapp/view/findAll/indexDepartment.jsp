<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Departments</title>
</head>
<body>

<h2>Список всех отделов</h2>
<p>
<li>
    <a href='<c:url value="./" />'>Вернутся на главную</a>
</li>
<li>
    <a href='<c:url value="/createDepartment"/>'>Добавление нового отдела</a>
</li>
</p>
<style>
    table {
        width: fit-content;
        background: white;
        color: #000000;
        border-spacing: 1px;
    }

    td, th {
        background: #d5d5d5;
        padding: 5px;
    }
</style>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Название отдела</th>
        <th></th>
    </tr>
    <c:forEach var="department" items="${department}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>
                <a href='<c:url value="/editDepartment?id=${department.id}"/>'>Редактировать</a> |
                <form method="post" action='<c:url value="/deleteDepartment" />' style="display:inline;">
                    <input type="hidden" name="id" value="${department.id}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
