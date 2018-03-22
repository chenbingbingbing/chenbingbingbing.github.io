<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="dao.Food"%>
<%@page import="java.util.HashMap"%>
<%@page import="cart.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
	</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:为购物车息提供界面
  -->
<body background="image/bg5.jpg">
	<%
     Object success = request.getAttribute("success");
     if(success!=null && !"".equals(success)){
 
  %>
     <script type="text/javascript">
         alert("<%=success%>");
     </script>    
  <%
  }
   %>
   
   <%
     Object failure = request.getAttribute("failure");
     if(failure!=null && !"".equals(failure)){
 
  %>
     <script type="text/javascript">
         alert("<%=failure%>");
     </script>    
  <%
  }
   %>
	
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar" role="navigation">
						<div class="navbar-header">
							<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					 	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
					 	<span class="icon-bar"></span>
					 		</button>
							<a class="navbar-brand" href="#">购物车</a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active">
									<a href="Cart_deal?action=entermainuser">首页</a>
								</li>
								<li class="active">
									<a href="Cart_deal?action=enteruserorder">订单</a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>
									菜品名称
								</th>
								<th>
									单价
								</th>
								<th>
									数量
								</th>
								<th>
									总价
								</th>
								<th>
									操作
								</th>
								<th>
									操作
								</th>
							</tr>
						</thead>
						<tbody>
						<!-- 循环的开始 -->
						<%
						 //首先判断session中是否有购物车对象
						if(request.getSession().getAttribute("cart")!=null)
						{													
						Cart cart = (Cart)request.getSession().getAttribute("cart");//从session中获取购物车对象
						HashMap<Food,Integer> foods = cart.getFoods();//调用Cart类的getFoods()方法
						Set<Food> items = foods.keySet();//获取HashMap<Food,Integer>的键值集合
						Iterator<Food> it = items.iterator();//获取迭代器
						while(it.hasNext()){
							Food food = it.next();
						%>
						
							<tr>
								<td>
									<%=food.getF_name() %>
								</td>
								<td>
									<%=food.getF_price() %>
								</td>
								<td>
									<%=foods.get(food) %>
								</td>
								<td>
									<%=foods.get(food)*food.getF_price() %>
								</td>
								<td>
									<a href="CartFoodDelete?id=<%=food.getF_id() %>">删除</a>
								</td>
								<td>
									<a href="CartToOrder_deal?foodname=<%=food.getF_name() %>&
									foodprice=<%=food.getF_price() %>&foodnum=<%=foods.get(food) %>&
									foodtotal=<%=foods.get(food)*food.getF_price() %>&
									id=<%=food.getF_id() %>">提交</a>
								</td>
							</tr>
					<%
						}
					%>
					
						</tbody>
					</table>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<span>总计：<%=cart.getTotalPrice() %></span>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</body>

</html>