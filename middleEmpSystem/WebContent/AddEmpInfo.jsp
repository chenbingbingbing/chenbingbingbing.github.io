<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工信息</title>
</head>
<body>
<form action="empServlet?action=addempinof" method="post">
	<label>员工姓名</label>
	<input type="text" name="empname"><br>
	<label>员工年龄</label>
	<input type="text" name="empage"><br>
	<label>员工性别</label>
	<input type="radio" name="empsex" value="1">男
	<input type="radio" name="empsex" value="0">女
	<br>
	<label>员工部门</label>
	<select name="empdept">
	<option value="1">网工部</option>
	<option value="2">财务部</option>
	<option value="3">IT部</option>
	</select>
	<br>
	<label>员工爱好</label>
	<input type="checkbox" name="hobby" value="1">打球
	<input type="checkbox" name="hobby" value="2">读书
	<input type="checkbox" name="hobby" value="3">游泳
	<input type="checkbox" name="hobby" value="4">旅行
	<br>
	<input type="submit" value="提交">
</form>
</body>
</html>