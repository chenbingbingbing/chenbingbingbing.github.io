<%@page import="sql.GetFoods"%>
<%@page import="dao.Food"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点餐界面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
		 /**
		  退出时弹出确认框
		  */
	      function exit(){
	    	  var message = "退出后点餐号将失效，确定退出？\n\n请确认！";
	    	  if(confirm(message)==true){
	    		  return true;
	    	  }else{
	    		  return false;
	    	  }
	      }
		 </script>
		<style type="text/css">
			/* Custom Styles */
			
			ul.nav-tabs {
				width: 140px;
				margin-top: 100px;
				border-radius: 4px;
				border: 1px solid #ddd;
				box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
			}
			
			ul.nav-tabs li {
				margin: 0;
				border-top: 1px solid #ddd;
			}
			
			ul.nav-tabs li:first-child {
				border-top: none;
			}
			
			ul.nav-tabs li a {
				margin: 0;
				padding: 8px 16px;
				border-radius: 0;
			}
			
			ul.nav-tabs li.active a,
			ul.nav-tabs li.active a:hover {
				color: #fff;
				background: #0088cc;
				border: 1px solid #0088cc;
			}
			
			ul.nav-tabs li:first-child a {
				border-radius: 4px 4px 0 0;
			}
			
			ul.nav-tabs li:last-child a {
				border-radius: 0 0 4px 4px;
			}
			
			ul.nav-tabs.affix {
				top: 30px;
				/* Set the top position of pinned element */
			}
		</style>

	</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：卢小庆；1161150281@qq.com
 测试人：卢小庆；1161150281@qq.com
安全等级：2 级
功能:为顾客点餐提供主界面
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
	
	<%
	String kind1 = "特色菜热菜";
	String kind2 = "面食";
	String kind3 = "素菜";
	String kind4 = "汤羹";
	String kind5 = "凉菜";
	GetFoods getFoods = new GetFoods();//实例化GetFoods类
	ArrayList<Food> HotFoods = getFoods.getAllFoods(kind1);//GetFoods类对象调用getAllFoods(String kind1)方法
	ArrayList<Food> NoodleFoods = getFoods.getAllFoods(kind2);
	ArrayList<Food> VegetableFoods = getFoods.getAllFoods(kind3);
	ArrayList<Food> DrinkFoods = getFoods.getAllFoods(kind4);
	ArrayList<Food> CoolFoods = getFoods.getAllFoods(kind5);
	%>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<nav class="navbar " role="navigation">
						<div class="navbar-header">
							<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
					 	<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
					 	<span class="icon-bar"></span></button>
							<a class="navbar-brand" href="#">点餐系统</a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active">
									<a href="Cart_deal?action=incart">购物车</a>
								</li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
							<li>
								<div class="text-info" align="center">欢迎您<%=session.getAttribute("userid") %>号</div>
							</li>
							<li>
									<a href="UserOrderDelete_deal?action=exit" onclick="javascript:return exit()">
										<div class="text-danger">注销
										</div>
									</a>
							</li>
							</ul>
						</div>

					</nav>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column" id="myScrollspy">
					<ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
						<li>
							<a href="#section-1">特色菜热菜</a>
						</li>
						<li>
							<a href="#section-2">面食</a>
						</li>
						<li>
							<a href="#section-3">素菜</a>
						</li>
						<li>
							<a href="#section-4">汤羹</a>
						</li>
						<li>
							<a href="#section-5">凉菜</a>
						</li>
					</ul>

				</div>
				<div class="col-md-10 column">
					<h2 id="section-1">特色菜热菜</h2>					
					<hr>											
					<div class="row clearfix">
					<%
						for(int j=0;j<HotFoods.size();j++){	//循环遍历ArrayList<Food>集合						
						Food food = HotFoods.get(j);//获取第j个food对象
						int foodid = food.getF_id();
						String id = String.valueOf(foodid);																
					%>
					
						<div class="col-md-4 column">
						<dl>
						<dt>
						<a href="Cart_deal?action=lookfood&id=<%=food.getF_id() %>">
						<img alt="" src="image/<%=food.getF_picturepath() %>" class="img-thumbnail">
						</a>
						</dt>
						<dd><h3> <%=food.getF_name() %>  </h3></dd>
						<dd><div class="text-danger">￥<%=food.getF_price() %> </div></dd>						
						</dl>
						</div>
						<% 
						}
						%>						
					</div>
					
					<h2 id="section-2">面食</h2>					
					<hr>
					<div class="row clearfix">
					<%
						for(int j=0;j<NoodleFoods.size();j++){							
						Food food = NoodleFoods.get(j);
					%>
						<div class="col-md-4 column">
						<dl>
						<dt>
						<a href="Cart_deal?action=lookfood&id=<%=food.getF_id() %>">
						<img alt="" src="image/<%=food.getF_picturepath() %>" class="img-thumbnail">
						</a>
						</dt>
						<dd><h3> <%=food.getF_name() %>  </h3></dd>
						<dd><div class="text-danger">￥<%=food.getF_price() %> </div></dd>		
						</dl>
						</div>
						<% 
						}
						%>
					</div>
											
					<h2 id="section-3">素菜</h2>					
					<hr>				
					<div class="row clearfix">
					<%
						for(int j=0;j<VegetableFoods.size();j++){							
						Food food = VegetableFoods.get(j);
					%>
						<div class="col-md-4 column">
						<dl>
						<dt>
						<a href="Cart_deal?action=lookfood&id=<%=food.getF_id() %>">
						<img alt="" src="image/<%=food.getF_picturepath() %>" class="img-thumbnail">
						</a>
						</dt>
						<dd><h3> <%=food.getF_name() %>  </h3></dd>
						<dd><div class="text-danger">￥<%=food.getF_price() %> </div></dd>	
						</dl>
						</div>
						<% 
						}
						%>
					</div>
					
					<h2 id="section-4">汤羹</h2>					
					<hr>					
					<div class="row clearfix">
					<%
						for(int j=0;j<DrinkFoods.size();j++){							
						Food food = DrinkFoods.get(j);
					%>
						<div class="col-md-4 column">
						<dl>
						<dt>
						<a href="Cart_deal?action=lookfood&id=<%=food.getF_id() %>">
						<img alt="" src="image/<%=food.getF_picturepath() %>" class="img-thumbnail">
						</a>
						</dt>
						<dd><h3> <%=food.getF_name() %>  </h3></dd>
						<dd><div class="text-danger">￥<%=food.getF_price() %> </div></dd>						
						</dl>
						</div>
						<% 
						}
						%>
					</div>					
					<h2 id="section-5">凉菜</h2>					
					<div class="row clearfix">
					<%
						for(int j=0;j<CoolFoods.size();j++){							
						Food food = CoolFoods.get(j);
					%>
						<div class="col-md-4 column">
						<dl>
						<dt>
						<a href="Cart_deal?action=lookfood&id=<%=food.getF_id() %>">
						<img alt="" src="image/<%=food.getF_picturepath() %>" class="img-thumbnail">
						</a>
						</dt>
						<dd><h3> <%=food.getF_name() %>  </h3></dd>
						<dd><div class="text-danger">￥<%=food.getF_price() %> </div></dd>								
						</dl>
						</div>
						<% 
						}
						%>
					</div>
					
				</div>	
				</div>
			</div>
	</body>
	</html>