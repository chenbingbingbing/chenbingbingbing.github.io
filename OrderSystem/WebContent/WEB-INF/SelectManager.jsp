<%@page import="dao.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
功能:为查询所有管理员信息提供界面
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
									管理员账号
								</th>
								<th>
									管理员密码
								</th>
								<th>
									管理员电话
								</th>
								<th>
									管理员姓名
								</th>
								
							</tr>
						</thead>
						<tbody>
						<%
							List<Manager> list = (List<Manager>)request.getAttribute("selectmanagerlist");//获取Admin_deal。java中保存在selectmanagerlist中的集合
							if(list==null||list.size()<1){
								out.print("查询不到数据！");
							}
							else{
								for(Manager manager:list){
									%>
								
							<tr>
								<td>
								<%=manager.getM_id() %>
								</td>
								<td>
								<%=manager.getM_password() %>
								</td>
								<td>
								<%=manager.getM_telephone() %>
								</td>
								<td>
								<%=manager.getM_name() %>
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