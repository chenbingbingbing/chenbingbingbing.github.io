<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：叶净芝；3243668278@qq.com
 测试人：叶净芝；3243668278@qq.com
安全等级：2 级
功能:提供登陆界面
  -->
<body background="image/bg6.jpg">
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
<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-center">
				                     点餐系统 
			      </h3>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					<img src="image/manager.png" class="img-circle" />
				</div>
				<div class="col-md-4">
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					<form class="form-horizontal" action="Login_deal" method="post">
						<div class="form-group">							
					<label class="col-sm-2 control-label" for="inputUername">
						用户名
					</label>
							<div class="col-sm-10">
								<input style="background:transparent; border:0; border-bottom:1px solid gray"  class="form-control" id="adminName" maxlength="10" name="adminName" type="text" placeholder="" />
							</div>
						</div>
						<div class="form-group">

							<label class="col-sm-2 control-label" for="inputPassword">
						密码
						</label>
							<div class="col-sm-10">
								<input style="background:transparent;border:0; border-bottom:1px solid gray"  class="form-control" id="adminPassword" maxlength="20" name="adminPassword" type="password" placeholder="" />
							</div>
						</div>
						<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">   
   						 <label class="radio-inline">
       				 		<input type="radio" name="optionsRadiosinline" id="optionsRadios1" value="option1" checked> 经理
   						 </label>
    					<label class="radio-inline">
        					<input type="radio" name="optionsRadiosinline" id="optionsRadios2"  value="option2"> 管理员
    					</label>
    					<label class="radio-inline">
        					<input type="radio" name="optionsRadiosinline" id="optionsRadios3"  value="option3"> 顾客
    					</label>
						</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-block btn-success btn-lg text-center" type="submit">
							登陆
								</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
</body>
</html>