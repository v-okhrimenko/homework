<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employees</title>
</head>
<body>
<h2>Список работников</h2>
<%--<% Object employees = request.getAttribute("employees"); %>--%>
<%--<%= employees%>--%>

<p>
<li>
    <a href='<c:url value="./" />'>Вернутся на главную</a>
</li>
<li>
    <a href='<c:url value="/create" />'>Добавить нового работника</a></p>
</li>
<table>
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
            <th>Подразделение</th>
            <th>ФИО</th>
            <th>Зарплата</th>
            <th>Начальник</th>
            <th></th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.department}</td>
                <td>${employee.name}</td>
                <td>${employee.salary}</td>
                <td>
                    <c:if test="${employee.chiefId == null}">
                        *
                    </c:if>
                </td>
                <td>
                    <a href='<c:url value="/edit?id=${employee.id}" />'>Edit</a> |
                    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                        <input type="hidden" name="id" value="${employee.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--</body>--%>
</html>
