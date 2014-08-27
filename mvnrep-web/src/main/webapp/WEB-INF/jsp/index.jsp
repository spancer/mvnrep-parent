<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/27
  Time: 22:31
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
    </tr>
    <c:forEach var="ga" items="${list}">
    <tr>
        <td><a href="<c:url value="/cvl/${ga['g']}/${ga['a']}"/>">${ga['a']}</a></td>
        <td>${ga['g']}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
