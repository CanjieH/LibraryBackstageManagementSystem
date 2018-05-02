
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getContextPath();
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理</title>
</head>
<body>
	<p><a href="<%=basePath%>/category.jsp" target="main">分类添加</a></p>
	<p><a href="<%=basePath%>/addBook.jsp" target="main">图书添加</a></p>
	<p><a href="<%=basePath%>/showBooks.jsp" target="main">图书查询</a></p>
</body>
</html>