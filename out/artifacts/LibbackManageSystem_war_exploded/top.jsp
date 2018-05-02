<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String user = (String)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<center>
		<h1>
			图书后台管理系统<span style="font-size:12px">您好，<%=user%></span></c:if>
		</h1>
	</center>
</body>
</html>
