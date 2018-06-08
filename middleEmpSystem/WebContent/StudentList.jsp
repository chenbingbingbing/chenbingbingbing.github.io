<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页</title>
</head>
<body>

<input type="text" id="noclear" name="noclear" value="${noclear }">
<button onclick="noclear()">搜索</button>
<table border="1">
	<c:forEach items="${list }" var="aa">
		<tr>
			<td>${aa.sid}</td>
			<td>${aa.sname}</td>			
		</tr>
	</c:forEach>
		<tr>
			<td colspan="10">		
				<button onclick="toPage(1)">首页</button>
				<button onclick="toPage(${pageUtil.prevPage})">上一页</button>
				<button onclick="toPage(${pageUtil.nextPage})">下一页</button>
				<button onclick="toPage(${pageUtil.lastPage})">尾页</button>
			</td>
    	</tr>
</table>

<script type="text/javascript">
	function toPage(page) {
		var noclear = document.getElementById("noclear").value;
		location.href="<%=request.getContextPath()%>/PageServlet?page="+page+"&noclear="+noclear;
	}
	function noclear() {
		var noclear = document.getElementById("noclear").value;
		location.href="<%=request.getContextPath() %>/PageServlet?noclear="+noclear;
	}
</script>
</body>
</html>