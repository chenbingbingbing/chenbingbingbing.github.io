<%@page import="dao.Food"%>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
功能:为编辑菜品信息提供界面
  -->
<body background="image/bgs7.jpg">
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

	<%
	Food food = (Food)request.getAttribute("food");//获取EditFood_deal.java中的food对象
	String foodid = String.valueOf(food.getF_id());
	String foodprice = String.valueOf(food.getF_price());
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
			<form role="form" method="post" action="EditFood2_deal" ENCTYPE="multipart/form-data">
				<div class="form-group">
					 <label for="foodId">菜品编号</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodid" type="text" name="foodid" placeholder="foodid" value="<%=foodid %>" disabled/>
				</div>
				<div class="form-group">
					 <label for="foodName">菜品名称</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodname" type="text" name="foodname" placeholder="foodname" maxlength="50" value="<%=food.getF_name() %>"/>
				</div>
				<div class="form-group">
					 <label for="foodtype">菜品种类</label>
					 <select style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" name=foodname>
      					<option value="">特色菜热菜</option>
      					<option value="">面食</option>
      					<option value="">素菜</option>
     					 <option value="">汤羹</option>
     					 <option value="">凉菜</option>
   					 </select>
				</div>
				<div class="form-group">
					 <label for="foodprice">菜品单价</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodprice" type="text" name="foodprice" placeholder="foodprice" value="<%=foodprice %>"/>
				</div>
				<div class="form-group">
					 <label for="fooddescribe">菜品描述</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="fooddescribe" name="fooddescribe" placeholder="fooddescribe" maxlength="100" value="<%=food.getF_describe() %>"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">选择图片</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" id="exampleInputFile" type="file" name="foodpath" value="<%=food.getF_picturepath() %>" />
				</div>									 
				<button class="btn btn-block btn-success" type="submit">更新</button>
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</body>
</html>