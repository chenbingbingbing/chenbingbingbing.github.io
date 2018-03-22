<%@page import="dao.Food"%>
<%@page import="sql.GetFoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>		
		<script type="text/javascript">
		 /**
		获取参数id,num参数值跳转到servlet处理
		  */
	  function selflog_show(id)
	 { 
	    var num =  document.getElementById("number").value; //根据文本框的id获取值
	    window.location.href="AddFoodToCart_deal?id="+id+'&num='+num+'&action=fooddetail';//窗口跳转
	 }
	  /**
	  控制文本框数量的加运算
	  */
      function add()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num<100)
         {
            document.getElementById("number").value = ++num;
         }
      }
      /**
	  控制文本框数量的减运算
	  */
      function sub()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
      }
     
    </script>
</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：卢小庆；1161150281@qq.com
 测试人：卢小庆；1161150281@qq.com
安全等级：2 级
功能:为显示详细菜品信息和让顾客加购物车提供界面
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

	<div>
	<h1>菜品详情</h1>
   <a href="Cart_deal?action=entermainuser">首页>></a>
   </div>
   <hr> 
 <div class="container">
	<div class="row">
		<div class="col-md-4">
  <%
   	GetFoods foods=new GetFoods();
   String id = (String)request.getAttribute("id"); 
   Food food = foods.GetFoodById(Integer.parseInt(id)); 
   if(food!=null){
   %>
 	
		<img src="image/<%=food.getF_picturepath() %>">																								
		</div>
		<div class="col-md-4">
		<table>
		
		<tr>
		<td>
				<h2><%=food.getF_name() %></h2>
				<div class="text-danger"><h4>¥<%=food.getF_price() %></h4></div>
				<h4>介绍:<%=food.getF_describe() %></h4>	
				<div class="form-group">
				购买数量：<span onclick="sub();">-</span>
				<input type="text" id="number" name="number" value="1" size="2">
				<span onclick="add();">+</span>
				</div>
				<div>		
				<a href="javascript:selflog_show(<%=food.getF_id() %>)"><img alt="" src="image/in_cart.png"></a>		
				<a href="Cart_deal?action=incart"><img src="image/view_cart.jpg"/></a>
				</div>	
			</td>
			</tr>
		<%
   		}
		%>		
		</table>				
		</div>
	
	<div class="col-md-4">
	
	</div>
	</div>
	</div>
</body>
</html>