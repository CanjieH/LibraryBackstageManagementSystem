<%--
  Created by IntelliJ IDEA.
  User: canjie
  Date: 2018/4/27
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String flag = request.getParameter("flag");
  String flag2 = request.getParameter("flag2");
  String basePath = request.getContextPath();
  String username = "";
  if(request.getParameter("username") != null){
    username = request.getParameter("username");
  }
%>

<html>
  <head>
    <title>图书后台管理登录界面</title>
    <script type="text/javascript">
         var flag = <%=flag%>;
         var flag2 = <%=flag2%>;
         if("1" == flag){
             alert("账号或密码输入错误，请重新输入！");
         }
         if("1" == flag2){
             alert("请先进行登录操作！");
         }
    </script>
  </head>
  <body>
  <center>
    <h1>登录 | <a href="<%=basePath%>/regist.jsp">注册</a></h1>
    <form action="<%=basePath%>/servlet/LoginServlet" method="post">
      <table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
        <tr>
          <td>用户名</td>
          <td><input type="text" name="username" value="<%=username%>" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
        </tr>
        <tr>
          <td>密&nbsp;码</td>
          <td><input type="password" name="password" placeholder="长度为6-12位的纯数字" ></td>
        </tr>
        <tr>
          <td colspan="2" style="text-align:center">
            <input type="submit" value="登录">
            <input type="reset" value="取消">
          </td>
        </tr>
      </table>
    </form>
  </center>
  </body>
</html>
