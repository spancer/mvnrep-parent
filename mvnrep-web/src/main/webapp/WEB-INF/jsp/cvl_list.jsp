<%--
  Created by IntelliJ IDEA.
  User: ZYW
  Date: 2014/8/27
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="tpls/header.jsp"/>
<div class="line">
    <div class="x2"></div>
    <div class="x7">
        <div class="panel" style="margin-bottom: 10px;">
            <div class="panel-head">GroupId ArtifactId</div>
            <div class="panel-body">
                <a href="#"><span class="tag bg-green">${list[0]['g']}</span></a>&nbsp;&nbsp;
                <a href="#"><span class="tag bg-main">${list[0]['a']}</span></a>
            </div>
        </div>
        <div class="panel" style="margin-bottom: 10px;">
            <div class="panel-head">描述</div>
            <div class="panel-body">
                等你来完善描述！
            </div>
        </div>
        <div class="panel" style="margin-bottom: 10px;">
            <div class="panel-head">有效的版本</div>
            <table class="table table-bordered">
                <tr>
                    <th>版本</th>
                    <th>类型</th>
                    <th>时间</th>
                    <th>点击率</th>
                </tr>
                <c:forEach var="ga" items="${list}">
                <tr>
                    <td><a class="gavInfo" href="javascript:;" data-options="${ga['g']},${ga['a']},${ga['v']}"><span class="badge bg-main">${ga['v']}</span></a></td>
                    <td>类型</td>
                    <td>${ga['timestamp']}</td>
                    <td>点击率</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="x3">
        <div class="collapse" style="margin: 0 10px;">
            <div class="panel active">
                <div class="panel-head"><h4>Apache Maven</h4></div>
                <div class="panel-body" id="maven_panel">

                </div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Apache Buildr</h4></div>
                <div class="panel-body">...</div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Apache Ivy</h4></div>
                <div class="panel-body">...</div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Groovy Grape</h4></div>
                <div class="panel-body">...</div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Gradle/Grails</h4></div>
                <div class="panel-body">...</div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Scala SBT</h4></div>
                <div class="panel-body">...</div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".gavInfo").click(function(){
            var opts = $(this).data("options");
            var gav = opts.split(',');
            var mvn = $.v5mr.maven(gav);
            console.log(mvn);
            $("#maven_panel").empty();
            $("#maven_panel").append(mvn);
            $('pre code').each(function(i, block) {
                hljs.highlightBlock(block);
            });
        });
    });
</script>
<jsp:include page="tpls/footer.jsp"/>
