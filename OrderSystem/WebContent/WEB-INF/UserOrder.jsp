<%@page import="sql.GetUserOrder"%>
<%@page import="dao.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<!--
程序名：CJ1.C  VER 3.0，2017-12-10 
编程人：卢小庆；1161150281@qq.com
 测试人：卢小庆；1161150281@qq.com
安全等级：2 级
功能:为显示顾客订单信息提供界面
  -->
<body background="image/bg5.jpg">
	<div class="container">
	<div>
	<h1>订单详情</h1>
   <a href="Cart_deal?action=entermainuser">首页>></a>
   </div>
   <hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>
									菜品名称
								</th>
								<th>
									用户餐号
								</th>
								<th>
									单价
								</th>
								<th>
									数量
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
							int UserId = (int)session.getAttribute("userid");//获取session中的点餐号
							GetUserOrder userOrder = new GetUserOrder();//实例化GetUserOrder类
							ArrayList<Menu> arrayList = userOrder.SelectUserOrder(UserId);//GetUserOrder类对象调用SelectUserOrder(int UserId)
							if(arrayList!=null&&arrayList.size()>0){
							for(int i=0;i<arrayList.size();i++){
								Menu menu = arrayList.get(i);
						%>
						
							<tr>
								<td>
								<%=menu.getF_name() %>	
								</td>
								<td>
								<%=menu.getUf_id() %>	
								</td>
								<td>
								<%=menu.getUf_price() %>	
								</td>
								<td>
								<%=menu.getUf_num() %>	
								</td>
								<td>
								<%=menu.getUf_totalprice() %>	
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