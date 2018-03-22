<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="dao.Food"%>
     <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询菜品</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
	<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:为查询所有菜品信息提供界面
  -->
	<body background="image/bgs7.jpg">
	
	<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar" role="navigation">
						<div class="navbar-header">
							<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
							 <span class="icon-bar"></span><span class="icon-bar"></span></button>
							<a class="navbar-brand" href="#">点餐系统后台管理</a>
						</div>

						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active">
									<a href="Admin_deal?action=admin">首页</a>
								</li>						
							</ul>						
						</div>
					</nav>
				</div>
			</div>
		</div>
	
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>
									菜品编号
								</th>
								<th>
									菜品名称
								</th>
								<th>
									菜品种类
								</th>
								<th>
									菜品单价
								</th>
								<th>
									图片名
								</th>
							</tr>
						</thead>
						<tbody>
						<%
							List<Food> list = (List<Food>)request.getAttribute("selectfoodlist");//获取Admin_deal。java中保存在selectfoodlist中的集合
							if(list==null||list.size()<1){
								out.print("查询不到数据！");
							}
							else{
								for(Food food:list){
									%>
								
							<tr>
								<td>
								<%=food.getF_id() %>
								</td>
								<td>
								<%=food.getF_name() %>
								</td>
								<td>
								<%=food.getF_kind() %>
								</td>
								<td>
								<%=food.getF_price() %>
								</td>
								<td>
								<%=food.getF_picturepath() %>
								</td>
							</tr>
						<%
							}
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>

</html>