<%--
  Created by IntelliJ IDEA.
  User: canjie
  Date: 2018/4/27
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>

<%--
主要功能：

1、注册登录功能

l  注册：信息包括用户名、密码、密码确认、手机号码和邮箱，要使用正则表达式进行校验

l  登录，注册成功直接跳转到登录页面并显示用户名

l  登录成功后进入管理页面。

l  使用过滤器限制不登录不能进入管理页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
    String flag5 = request.getParameter("flag5");
    String flag = request.getParameter("flag");
    String username = request.getParameter("username");
%>

<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript">
        var flag5 = <%=flag5%>;
        var flag = <%=flag%>;
        if("1"==flag5){
            alert("两次输入的密码不一致，请重新注册!");
        }
        else if("1"==flag){
            alert("注册信息格式不符合要求，请重新注册!");
        }
        else if("0"==flag){
            alert("注册成功!");
            window.location.href = "<%=basePath%>/index.jsp?username=<%=username%>";
        }
    </script>
</head>
<body>
<center>
    <h1>用户注册</h1>
    <form action="<%=basePath%>/servlet/RegistServlet" method="post">
        <table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合" pattern="[\w]{3,12}"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td><input type="password" name="password" placeholder="密码长度为6-12位的纯数字"  id="password" pattern="[0-9]{6,12}"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="checkPWD" placeholder="密码长度为6-12位的纯数字" pattern="[0-9]{6,12}"></td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td><input type="text" name="phone" placeholder="请输入正确的手机号码格式" pattern="1[3578]\d{9}"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" name="email" placeholder="请输入正确邮箱格式" required="required"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center">
                    <input type="submit" value="注册">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
