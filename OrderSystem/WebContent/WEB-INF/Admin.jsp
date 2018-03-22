<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理主页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:为用户类型为经理提供主界面
  -->
<body background="image/bg1.jpg">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar navbar-fixed-top" role="navigation">
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
								<li class="dropdown">
									<a class="dropdown-toggle" href="#" data-toggle="dropdown">菜单管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="Admin_deal?action=addfood">添加菜品</a>
										</li>
										<li>
											<a href="Admin_deal?action=editfood">编辑菜品</a>
										</li>
										<li class="divider">
										</li>
											<li>
												<a href="Admin_deal?action=selectfood">查看菜品</a>
											</li>									
										<li>
											<a href="Admin_deal?action=deletefood">删除菜品</a>
										</li>
									</ul>
								</li>
								<li class="dropdown">
									<a class="dropdown-toggle" href="#" data-toggle="dropdown">管理员管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li>
											<a href="Admin_deal?action=addmanager">添加管理员</a>
										</li>
										<li>
											<a href="Admin_deal?action=deletemanager">删除管理员</a>
										</li>
										<li class="divider">
										</li>
										<li>
											<a href="Admin_deal?action=selectmanager">查看管理员信息</a>
										</li>
									</ul>
								</li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
							<li>
										<div class="text-info" align="center">欢迎您<%=session.getAttribute("adminName") %></div>
							</li>
								<li>
									<a href="Admin_deal?action=exit">
										<div class="text-danger">注销
										</div>
									</a>
								</li>
							</ul>
						</div>

					</nav>
				</div>
			</div>
		</div>
</body>
</html>