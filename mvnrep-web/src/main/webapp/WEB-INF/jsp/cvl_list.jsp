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
            <div class="panel-head">GroupId ArtifactId</div>
            <div class="panel-body">
                <a href="#"><span class="tag bg-green">${list[0].groupId}</span></a>&nbsp;&nbsp;
                <a href="#"><span class="tag bg-main">${list[0].artifactId}</span></a>
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
                    <td>
                        <a class="gavInfo" href="javascript:;"
                           data-options="${ga.groupId},${ga.artifactId},${ga.version}">
                        <span class="badge ${ga.jarcolor}">${ga.version}</span>
                    </a></td>
                    <td>${ga.jartype}</td>
                    <td>${ga.builderTime}</td>
                    <td>
                        <small class="float-right"><em>${ga.clickRatio}</em></small>
                        <small><em>点击数</em></small>
                        <div class="progress progress-small">
                            <div class="progress-bar bg-yellow" style="width:${ga.progress}%;"></div>
                        </div>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="x3">
        <div class="collapse" style="margin: 0 10px;">
            <div class="panel active">
                <div class="panel-head"><h4>Apache Maven</h4></div>
                <div class="panel-body" id="maven_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Apache Buildr</h4></div>
                <div class="panel-body" id="builder_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Apache Ivy</h4></div>
                <div class="panel-body" id="ivy_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Groovy Grape</h4></div>
                <div class="panel-body" id="grape_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Gradle/Grails</h4></div>
                <div class="panel-body" id="gradle_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Scala SBT</h4></div>
                <div class="panel-body" id="sbt_panel" style="padding: 0;"></div>
            </div>
            <div class="panel">
                <div class="panel-head"><h4>Leiningen</h4></div>
                <div class="panel-body" id="leiningen_panel" style="padding: 0;"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".gavInfo").click(function(){
            var opts = $(this).data("options");
            var gav = opts.split(',');

            $.post("<c:url value="/jcre/edit"/>"+"?t="+new Date().getTime(),{g:gav[0],a:gav[1],v:gav[2]},function(data){

            });

            var mvn = $.v5mr.maven(gav);
            $("#maven_panel").empty();
            $("#maven_panel").append(mvn);

            var buildr = $.v5mr.buildr(gav);
            $("#builder_panel").empty();
            $("#builder_panel").append(buildr);

            var ivy = $.v5mr.ivy(gav);
            $("#ivy_panel").empty();
            $("#ivy_panel").append(ivy);

            var grape = $.v5mr.grape(gav);
            $("#grape_panel").empty();
            $("#grape_panel").append(grape);

            var gradle = $.v5mr.gradle(gav);
            $("#gradle_panel").empty();
            $("#gradle_panel").append(gradle);

            var sbt = $.v5mr.sbt(gav);
            $("#sbt_panel").empty();
            $("#sbt_panel").append(sbt);

            var leiningen = $.v5mr.leiningen(gav);
            $("#leiningen_panel").empty();
            $("#leiningen_panel").append(leiningen);

            $('pre code').each(function(i, block) {
                hljs.highlightBlock(block);
            });
        });
    });
</script>
<jsp:include page="tpls/footer.jsp"/>
