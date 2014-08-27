<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/27
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <tr>
        <td>artifactId</td>
        <td>groupId</td>
        <td>version</td>
        <td>download</td>
    </tr>
    <c:forEach var="ga" items="${list}">
        <tr>
            <td>${ga['a']}</td>
            <td>${ga['g']}</td>
            <td>${ga['v']}</td>
            <td>
                <c:forEach var="re" items="${ga['ec']}">
                <a href="#">${re}</a>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
