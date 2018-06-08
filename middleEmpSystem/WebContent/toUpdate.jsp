<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新页面</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/empServlet?action=update" method="post">
		<input type="hidden" name="id" value="${emp.id }">
		<br>
		<label>员工姓名</label>
		<input type="text" name="empname" value="${emp.name }">
		<br>
		<label>员工年龄</label>
		<input type="text" name="empage" value="${emp.age }">
		<br>
		<label>员工性别</label>
		<input type="radio" name="empsex" value="1" 
		 <c:choose>
		 	<c:when test="${emp.sex==1}">checked="checked"</c:when>
		 	<c:otherwise></c:otherwise>
		 </c:choose>
		 >		
		<input type="radio" name="empsex" value="0" 
			<c:choose>
		 	<c:when test="${emp.sex==0}">checked="checked"</c:when>
		 	<c:otherwise></c:otherwise>
		 </c:choose>
		>
		<br>
		
		<label>员工部门</label>
		<select name="empdept">
		<c:forEach items="${deptlist }" var="depts">
		<option value="${depts.did }"
		<c:if test="${emp.did==depts.did }"> selected="selected" 
		</c:if>	
		>${depts.dname }
		</option>
		</c:forEach>
		</select>
		<br>
		<label>员工爱好</label>
		
		<c:forEach items="${hobbylist }" var="hobbys">
		<input type="checkbox" name="hobby" value="${hobbys.hid }"
		
		<c:forEach items="${emp.hobbylist }" var="eh">
			<c:if test="${eh.hid==hobbys.hid }">
			checked="checked"
			</c:if>
		</c:forEach>
		
		>${hobbys.hname}
		</c:forEach>		
		<br>
		<input type="submit" value="更新">
	</form>
</body>
</html>