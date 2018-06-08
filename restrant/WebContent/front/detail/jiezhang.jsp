<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath=request.getContextPath();
	String basePath=request.getContextPath()+"/front";
%>
<script>alert('尊敬的顾客,您好!已经通知服务员结账，请稍等!');window.location.href='<%=contextPath %>/frontController'</script>