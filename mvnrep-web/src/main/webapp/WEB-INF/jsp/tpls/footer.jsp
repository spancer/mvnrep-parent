<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a id="backtop" data-position="fixed" data-bottom="20px" data-right="20px" style="cursor:pointer;">
    <img src="<c:url value="/r/images/up.png"/>">
</a>
<div class="container-layout">

    <div class="border-top padding-top">
        <div class="text-center">
            <ul class="nav nav-inline">
                <li class="active"><a href="#">网站首页</a></li>
                <li><a href="#">新闻资讯</a></li>
                <li><a href="#">产品中心</a></li>
                <li><a href="#">技术反馈</a></li>
                <li><a href="#">留言反馈</a></li>
                <li><a href="#">联系方式</a></li>
            </ul>
        </div>
        <div class="text-center height-big">版权所有 © Pintuer.com All Rights Reserved，图ICP备：380959609</div>
    </div>

</div>
<script type="text/javascript">
    $(function(){
        $('#backtop').scollTop({
            scrollDuration:1000, //指定回到顶部所用时间 1 秒
            scrollTop:200 // 指定浏览器滚动条滚动大于200px的时候，显示回到顶部链接
        })
    });
</script>
</body>
</html>
