<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改菜品</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
	<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:为查询指定id菜品信息提供界面
  -->
	<body background="image/bgs7.jpg">
	  
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
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
			<form role="form" action="EditFood_deal" method="post">				
				<div class="form-group">
					 <label for="foodid">菜品编号</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodid" name="foodid" type="text" placeholder=""/>
				</div>
				<button class="btn btn-block btn-info" type="submit">查询</button>
				
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</html>