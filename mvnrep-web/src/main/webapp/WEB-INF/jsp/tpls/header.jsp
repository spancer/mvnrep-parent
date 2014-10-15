<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/28
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>V5MR</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/r/css/pintuer.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/r/css/github.css"/>">
    <link type="text/css" rel="stylesheet" href="<c:url value="/r/css/style.css"/>">
    <script type="text/javascript" src="<c:url value="/r/js/jquery-1.9.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/r/js/highlight.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/r/js/app.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/r/js/pintuer.js"/>"></script>
</head>
<body>
    <div class="layout doc-header fixed fixed-top">
        <div class="x4"></div>
        <div class="x4" style="height: 120px;">
            <div class="form-group">
                <div class="field">
                    <div class="input-group" style="margin-top: 35px;">
                        <input type="text" id="searchVal" class="input input-big" name="s" size="50" placeholder="关键字" />
                        <span class="addbtn"><button type="button" id="searchGAV" class="button input-big">搜!</button></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="x4"></div>
    </div>
<script type="text/javascript">
    $(function(){
        $("#searchGAV").click(function(){
            var sv = $("#searchVal").val();
            var url = "<c:url value="/search"/>"+"/"+sv;
            location.href = url;
        });
        $("#serachHeader").scrollspy({
            min: 20,
            max:($(document).height()),
            onEnter: function(element, position) {
                $("#serachHeader").addClass('fixed-top');
            },
            onLeave: function(element, position) {
                $("#serachHeader").removeClass('fixed-top');
            }
        });
        $("#searchVal").keydown(function(e){
            if(13 === e.keyCode){
                var sv = $("#searchVal").val();
                var url = "<c:url value="/search"/>"+"/"+sv;
                location.href = url;
            }
        });
    });
</script>