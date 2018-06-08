<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示员工信息</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/AddEmpInfo.jsp">添加</a>
	<table border="1">
	<tr>
	<td>职工号</td>
	<td>姓名</td>
	<td>性别</td>
	<td>年龄</td>
	<td>部门名称</td>
	<td>爱好</td>
	<td colspan="2"></td>
	</tr>
	<c:forEach items="${emplist }" var="empvalue">
		<tr>
			<td>${empvalue.id }</td>
			<td>${empvalue.name }</td>
			<td>${empvalue.sex==1?"男":"女" }</td>
			<td>${empvalue.age }</td>
			<td>${empvalue.dname }</td>
			<td>
			<c:forEach items="${empvalue.hobbylist }" var="hobby">
				${hobby.hname }/
			</c:forEach>
			</td>
			<td><a href="<%=request.getContextPath() %>/empServlet?action=toupdate&id=${empvalue.id }">更新</a></td>
			<td><a href="<%=request.getContextPath() %>/empServlet?action=todelete&id=${empvalue.id }">删除</a></td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>