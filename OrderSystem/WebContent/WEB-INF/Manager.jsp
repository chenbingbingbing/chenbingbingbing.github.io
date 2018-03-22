<%@page import="dao.Menu"%>
<%@page import="sql.GetUserOrder"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
	<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：卢小庆；1161150281@qq.com
 测试人：卢小庆；1161150281@qq.com
安全等级：2 级
功能:为后厨管理员提供主界面
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
					<nav class="navbar" role="navigation">
						<div class="navbar-header">
							<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					 	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
					 	<span class="icon-bar"></span></button>
					 		<a class="navbar-brand" href="UserOrderDelete_deal?action=return">首页</a>
							<a class="navbar-brand" href="UserOrderDelete_deal?action=orderdeal">订单处理</a>
							<a class="navbar-brand" href="UserOrderDelete_deal?action=userdeal">点餐号处理</a>
						</div>
						<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="Login.jsp">
										<div class="text-danger">注销
										</div>
									</a>
								</li>
						</ul>
					</nav>
				</div>
			</div>

			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>
									用户餐号
								</th>
								<th>
									菜品名称
								</th>
								<th>
									数量
								</th>
								<th>
									单价
								</th>
								<th>
									总价
								</th>
								<th>
									下单日期
								</th>
							</tr>
						</thead>
						<tbody>
						<%
						GetUserOrder getUserOrder = new GetUserOrder();//实例化GetUserOrder类
						ArrayList<Menu> arrayList = getUserOrder.SelectAllUserOrder();//GetUserOrder类对象调用SelectAllUserOrder()方法
						if(arrayList!=null&&arrayList.size()>0){//判断集合是否不为空而且数量大于0
							for(int i=0;i<arrayList.size();i++){//循环遍历集合
								Menu menu = arrayList.get(i);//获取集合第i个对象
						%>											
							<tr>
								<td>
								<%=menu.getUf_id() %>号	
								</td>
								<td>
								<%=menu.getF_name() %>	
								</td>
								<td>
								<%=menu.getUf_num() %>份		
								</td>
								<td>
								<%=menu.getUf_price() %>元
								</td>
								<td>
								<%=menu.getUf_totalprice() %>元	
								</td>
								<td>
								<%=menu.getUf_date() %>	
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