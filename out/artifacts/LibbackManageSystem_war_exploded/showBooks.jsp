<%@ page import="com.canjie.model.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.canjie.DAO.LibDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getContextPath();
	LibDaoImpl libDao = new LibDaoImpl();
	ArrayList<Book> Books = libDao.getAllBooks();
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
	<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="categoryName">
			<input type="submit" value="查询" id="search">
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
				<%
					for(Book b : Books){

				%>
					<tr>
						<td><%=b.getId()%></td>
						<td><%=b.getName()%></td>
						<td><%=b.getCategory()%></td>
						<td><%=b.getPrice()%></td>
						<td><%=b.getDescript()%></td>
					</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>
	
</body>
<script type="text/javascript">
    $("#search").click(function(){
        //单击查询按钮的时候触发ajax事件
        $.ajax({
            url:"<%=basePath%>/servlet/SearchServlet",
            type:"post",
            data:{
                id:$("input[name=bookID]").val(),
                name:$("input[name=bookName]").val(),
				category:$("input[name=categoryName]").val()
            },
            dataType:"json",
            success:function(result){
				var list = eval(result);
				var content = null;
				for(var i in list){
				    var id = list[i].id;
				    var name = list[i].name;
				    var category = list[i].category;
				    var price = list[i].price;
				    var descript = list[i].descript;
				    content = content + "<tr><td>" + id + "</td><td>" + name + "</td><td>" + category + "</td><td>" + price + "</td><td>" + descript + "</td></tr>";
				    $("#cont>tr").remove();
				}
				$("#cont").html(content);
            }

        });
    });
</script>
</html>