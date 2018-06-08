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
	<script type="text/javascript" src="<%=basePath %>/style/js/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/style/css/index.css" />
	<script type="text/javascript">
		 // 删除菜品项
		function removeSorder(id) {
			window.location.href = "<%=contextPath %>/frontController?method=removeCart&id="+id;
		}
		/**
		// 修改菜品项数量
		function alterSorder(node) {
			var snumber = node.value;
			var gid = node.lang;
			window.location.href = "/wirelessplatform/sorder.html?method=alterSorder&gid="+gid+"&snumber="+snumber;
		}*/
		
		// 下单
		function takeOrders(totalPrice) {
			var count = $("input[name='foodCount']");
			var foodCount = [];
			for(var i=0;i<count.length;i++){
				foodCount.push($(count[i]).val());
			}
			var foodCounts = foodCount.join("-");
			location.href = "<%=contextPath %>/frontController?method=takeOrder&totalPrice="+totalPrice+"&foodCounts="+foodCounts;
		}
	</script>
	
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%" border="1">
					<tr height="40">
				 		<td align="center" width="20%">菜名</td>
				 		<td align="center" width="20%">单价</td>
				 		<td align="center" width="20%">数量</td>
				 		<td align="center" width="20%">小计</td>
				 		<td align="center" width="20%">操作</td>
				 	</tr>
				 	<c:forEach items="${sessionScope.cart }" var="c">
					<tr height="60">
					 		<td align="center" width="20%">${c.foodName }</td>
					 		<td align="center" width="20%">￥${c.price }</td>
					 		<td align="center" width="20%">
					 			<input type="text" id="foodCount" name="foodCount" value="1" size="3" lang="3" onblur="alterSorder(this)"/>
					 		</td>
					 		<td align="center" width="20%">${c.price }</td>
					 		<td align="center" width="20%">
					 			<input type="button" value="删除" class="btn_next" lang="3" onclick="removeSorder(${c.id})" />
					 		</td>
				 	</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;&nbsp;
							<%
							Set<Food> cart = (Set<Food>)request.getSession(false).getAttribute("cart");
							Double totalPrice=0.0;
							if(cart!=null){								
								Iterator<Food> iterator = cart.iterator();
								while(iterator.hasNext()){
									Food food = iterator.next();
									totalPrice+=food.getPrice();
								}
							}
							
							%>
							<%=totalPrice %>
							</span>
							<label
								id="counter" style="font-size:36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">																							
							<input type="button" value="下单" class="btn_next" onclick="takeOrders(<%=totalPrice %>)" />															
						</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_3">
				<!-- 搜索菜品表单  -->				
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
