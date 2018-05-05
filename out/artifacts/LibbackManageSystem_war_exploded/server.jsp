<%--
  Created by IntelliJ IDEA.
  User: canjie
  Date: 2018/4/28
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>

<html>
<head>
    <title>图书后台管理系统</title>
    <script type="text/javascript">
        //解决子框架嵌套的问题
        if(window != window.parent){
            window.top.location.href=location.href;
        }
    </script>
</head>
<frameset rows="20%,*">
    <frame src="<%=basePath%>/top.jsp"></frame>
    <frameset cols="10%,*">
        <frame src="<%=basePath%>/left.jsp"></frame>
        <frame name="main"></frame>
    </frameset>
</frameset>
</html>
