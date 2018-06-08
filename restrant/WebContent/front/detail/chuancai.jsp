<%@page import="com.baidu.util.PageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath=request.getContextPath();
	String basePath=request.getContextPath()+"/front";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath %>/style/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/style/js/page_common.js"></script>
<link href="<%=basePath %>/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/style/css/index_1.css" />
	<link href="<%=basePath %>/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${list }" var="l">
						<li>
							<dl>
								<dt>
									<a href="<%=contextPath %>/frontController?method=getFoodDetail&id=${l.id}">
										<img width="214px" height="145px" src="<%=basePath %>/style/images/guotourou.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="<%=contextPath %>/frontController?method=getFoodDetail&id=${l.id}">${l.foodName }</a>
								</dd>
								<dd class="f2">
									<a href="<%=contextPath %>/frontController?method=getFoodDetail&id=${l.id}">&yen;${l.price }</a>
								</dd>
							</dl>
						</li>											
				</c:forEach>	
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">														
				<span style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
				<a href="<%=contextPath %>/frontController?method=getTypeFood&id=${foodTypeId }&page=${pageUtils.prevPage}" style="font-weight:bold">&lt;&lt;</a>
				</span>									
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->						
					<% 
						PageUtil pageUtils = (PageUtil)request.getAttribute("pageUtils");
						if(pageUtils!=null){
						for(int i=1;i<=pageUtils.getLastPage();i++){
					%>					
						<li><a href="<%=contextPath %>/frontController?method=getTypeFood&id=<%=request.getAttribute("foodTypeId") %>&page=<%=i%>"><%=i %></a></li>										
					<%	
						}
						}
					%>								
					</ul>
				</div>
					<span style="float:right; line-height:53px; margin-right:10px;  ">
						<a href="<%=contextPath %>/frontController?method=getTypeFood&id=${foodTypeId }&page=${pageUtils.nextPage}" style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
					</span>									
			</div>			
		</div>
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="clientOrderList.html">
							<img src="<%=basePath %>/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>
			<div id="dish_2">
				<ul>
					<c:forEach items="${cuisines }" var="cu">
						<li>
							<a href="<%=contextPath %>/frontController?method=getTypeFood&id=${cu.id}">${cu.typeName }</a>
						</li>
					</c:forEach>			
				</ul>
			</div>
			<div id="dish_3">
				<!--菜品表单  -->
					<table width="166px">			
						<tr>
							<td>
								<a href="<%=contextPath %>/frontController?method=getFoodList&id=${sessionScope.tableid}">
									<img src="<%=basePath %>/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>		
			</div>
		</div>
		
	</div>
</body>
</html>
