<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理订单</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
	<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：卢小庆；1161150281@qq.com
 测试人：卢小庆；1161150281@qq.com
安全等级：2 级
功能:为顾客订单完成处理提供界面
  -->
	<body background="image/bgs8.jpg">
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
					<h3 class="text-center text-info">
					处理订单
					</h3>
					<a href="UserOrderDelete_deal?action=return">首页>></a>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
					<form action="UserOrderDelete2" method="post">
						<div class="form-group">
							<label for="foodid">点餐号</label>
							<input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="orderid" name="userorderid" type="text" placeholder="1~100" />
						</div>
						<button class="btn btn-block btn-info" type="submit">订单完成</button>
					</form>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</body>

</html>