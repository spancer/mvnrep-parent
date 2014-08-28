<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/28
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="tpls/header.jsp"/>
<div class="line">
    <div class="x2"></div>
    <div class="x7">
        <c:forEach var="ga" items="${list}">
            <div style="padding-bottom: 5px;">
                <blockquote class="border-sub">
                    <a href="<c:url value="/cvl/${ga['g']}/${ga['a']}"/>"><strong>${ga['a']}</strong></a>
                    <p style="padding-left: 10px;color:#666666">等你来完善描述！</p>
                    <span style="padding-left: 10px;font-size: 12px;color: #bbbbbb">${ga['g']} : ${ga['a']}</span>
                </blockquote>
            </div>
        </c:forEach>
    </div>
    <div class="x3"></div>
</div>
<jsp:include page="tpls/footer.jsp"/>
