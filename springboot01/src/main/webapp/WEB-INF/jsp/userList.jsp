<%--
  Created by IntelliJ IDEA.
  User: charmFlightChen
  Date: 2021/7/3 0003
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" align="center" width="50%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>AGE</td>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
