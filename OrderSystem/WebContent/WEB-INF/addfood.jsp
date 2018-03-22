<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加菜品</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:为添加菜品信息提供界面
  -->
<body background="image/bgs7.jpg">
<%
     Object success = request.getAttribute("success");//获取request中的success变量
     if(success!=null && !"".equals(success)){//判断seccess是否不为空而且不为空字符串
 
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
			<form method="post" action="AddFood_deal" ENCTYPE="multipart/form-data">
				<div class="form-group">
					 <label for="foodId">菜品编号</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodid" name="foodid" type="text" placeholder="例1，2，3"/>
				</div>
				<div class="form-group">
					 <label for="foodName">菜品名称</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodname" name="foodname" type="text" maxlength="50" placeholder="不超过50字符"/>
				</div>
				<div class="form-group">
					 <label for="foodtype">菜品种类</label>
					<select style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" name=foodtype>
      					<option value="特色菜热菜">特色菜热菜</option>
      					<option value="面食">面食</option>
      					<option value="素菜">素菜</option>
     					 <option value="汤羹">汤羹</option>
     					 <option value="凉菜">凉菜</option>
   					 </select>
				</div>
				<div class="form-group">
					 <label for="foodprice">菜品单价</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodprice" name="foodprice" type="text"  placeholder="例15，20"/>
				</div>
				<div class="form-group">
					 <label for="fooddescribe">菜品描述</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="fooddescribe" name="fooddescribe" maxlength="100" placeholder="不超过100字符"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">选择图片</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" id="exampleInputFile" name="foodpath" type="file" />													 					
				</div>
				<input class="btn btn-block btn-success" type="submit" value="提交">
				
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</body>
</html>