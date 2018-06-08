<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hotel.pojo.OrderDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Iterator"%>
<%@page import="com.hotel.pojo.Food"%>
<%@page import="java.util.Set"%>
<%
	String contextPath=request.getContextPath();
	String basePath=request.getContextPath()+"/front";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/style/css/index.css" />
	<script type="text/javascript">
		// 通知服务员结账
		function callPay(orderId) {
			window.location.href = "<%=contextPath %>/frontController?method=clearAccount&id="+orderId;
		}
	</script>
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
				 		<td align="center" width="20%">菜名</td>
				 		<td align="center" width="20%">单价</td>
				 		<td align="center" width="20%">数量</td>
				 		<td align="center" width="20%">小计</td>
				 	</tr>
					<c:forEach items="${list }" var="l">
					<tr height="60">
					 		<td align="center" width="20%">${l.foodName }</td>
					 		<td align="center" width="20%">￥${l.price }</td>
					 		<td align="center" width="20%">${l.foodCount }</td>
					 		<td align="center" width="20%">${l.price*l.foodCount }</td>
				 	</tr>
				 	</c:forEach>
					<tr>
						<td colspan="6" align="right">总计:
							<%
							Double sum=0.0;
							List<OrderDetail> orderDetails = (List<OrderDetail>)request.getAttribute("list");
							for(int i=0;i<orderDetails.size();i++){
								Integer count = orderDetails.get(i).getFoodCount();
								Double price = orderDetails.get(i).getPrice();
								sum+=(count*price);
							}
							%>							
							<span style="font-size:36px;">&yen;<%=sum %></span>
							<label id="counter" style="font-size:36px">
							
							</label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							<input type="button" value="结账" class="btn_next" lang="" onclick="callPay(${orderId})" />
						</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_3">
				<!-- 菜品表单  -->
					<table width="166px">				
						<tr>
							<td>
								<a href="/wirelessplatform/food.html?method=selectFood">
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
