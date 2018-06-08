<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String contextPath=request.getContextPath();
	String basePath=request.getContextPath()+"/front";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=basePath %>/style/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/style/js/page_common.js"></script>
<link href="<%=basePath %>/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/style/css/index_1.css" />
	<link href="<%=basePath %>/style/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/style/css/dis_message.css" />
</head>
<body style="text-align: center">
	<div id="all">
		<!--左边菜品详细信息 -->
		<div id="menu1">
			<div class="menu2" style="text-align:center;">
				<img src="<%=basePath %>/style/images/order_detials_bg.png" />
			</div>
			<div class="menu3">
				<div class="menu3_left">
					<img src="<%=contextPath %>/${food.img}" style="width:270px; height:290px;" />
				</div>
				<div class="menu3_right">
					<p>菜名:${food.foodName }</p>
					<p>价格:&nbsp;&nbsp;&yen;&nbsp;${food.price }</p>
					<p>简介:${food.remark }</p>
				</div>
			</div>
			<div class="menu4">				
				<a href="<%=contextPath %>/frontController?method=addCart&id=${food.id}" style="background:url(<%=basePath %>/style/images/img/order_left_corner_bg.png);">放入餐车</a>
				<a href="#" onclick="javascript:history.go(-1);" style="background:url(<%=basePath %>/style/images/img/order_right_corner_bg.png);">返回</a>
			</div>
		</div>
		
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			
			<div id="dish_3">
				<!-- 菜品表单  -->			
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
