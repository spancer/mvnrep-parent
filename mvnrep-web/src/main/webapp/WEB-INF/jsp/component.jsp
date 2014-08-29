<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/27
  Time: 22:31
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
    </div>
    <div class="x7">
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">GroupId ArtifactId</div>
            <div class="panel-body">
                <a href="#"><span class="tag bg-green">${list[0]['g']}</span></a>&nbsp;&nbsp;
                <a href="#"><span class="tag bg-main">${list[0]['a']}</span></a>
            </div>
        </div>
    </div>
    <div class="x3">
        <div class="panel" style="margin: 0 10px 10px 10px;">
            <div class="panel-head">没想好</div>
            <div class="panel-body">

            </div>
        </div>
    </div>
</div>
<jsp:include page="tpls/footer.jsp"/>
