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
<div class="line" style="margin-top: 135px;">
    <div class="x2">
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">没想好</div>
            <div class="panel-body">

            </div>
        </div>
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">没想好</div>
            <div class="panel-body">

            </div>
        </div>
    </div>
    <div class="x7">
        <div class="panel" style="margin-bottom: 10px;">
            <div class="panel-head">查询列表</div>
            <div class="panel-body">
                <c:forEach var="ga" items="${list}">
                    <%--<div style="padding-bottom: 5px;">--%>
                    <%--<blockquote>--%>
                    <%--<a href="<c:url value="/cvl/${ga['g']}/${ga['a']}"/>"><strong>${ga['a']}</strong></a>--%>
                    <%--<p style="padding-left: 10px;color:#666666">等你来完善描述！</p>--%>
                    <%--<span style="padding-left: 10px;font-size: 12px;color: #bbbbbb">${ga['g']} : ${ga['a']}</span>--%>
                    <%--</blockquote>--%>
                    <%--</div>--%>
                    <div class="shadow-wrapper">
                        <blockquote class="hero box-shadow shadow-effect-2">
                            <p class="float-right">最新版本：${ga.latestVersion}</p>
                            <p><a href="<c:url value="/cvl/${ga.groupId}/${ga.artifactId}"/>"><strong>${ga.groupId} : ${ga.artifactId}</strong></a></p>

                            <p><em>等你来完善描述！</em></p>

                            <small><em>点击数</em></small> : <span class="badge bg-green">${ga.clickRatio}</span>
                        </blockquote>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
    <div class="x3">
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">没想好</div>
            <div class="panel-body">

            </div>
        </div>
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">没想好</div>
            <div class="panel-body">

            </div>
        </div>
    </div>
</div>
<jsp:include page="tpls/footer.jsp"/>
