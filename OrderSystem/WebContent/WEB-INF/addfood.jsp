<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>��Ӳ�Ʒ</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	</head>
<!--
��������CJ1.C  VER 3.0��2017-12-10 
����ˣ�Ҷ��֥��3243668278@qq.com
 �����ˣ�Ҷ��֥��3243668278@qq.com
��ȫ�ȼ���2 ��
����:Ϊ��Ӳ�Ʒ��Ϣ�ṩ����
  -->
<body background="image/bgs7.jpg">
<%
     Object success = request.getAttribute("success");//��ȡrequest�е�success����
     if(success!=null && !"".equals(success)){//�ж�seccess�Ƿ�Ϊ�ն��Ҳ�Ϊ���ַ���
 
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
							<a class="navbar-brand" href="#">���ϵͳ��̨����</a>
						</div>

						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active">
									<a href="Admin_deal?action=admin">��ҳ</a>
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
					 <label for="foodId">��Ʒ���</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodid" name="foodid" type="text" placeholder="��1��2��3"/>
				</div>
				<div class="form-group">
					 <label for="foodName">��Ʒ����</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodname" name="foodname" type="text" maxlength="50" placeholder="������50�ַ�"/>
				</div>
				<div class="form-group">
					 <label for="foodtype">��Ʒ����</label>
					<select style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" name=foodtype>
      					<option value="��ɫ���Ȳ�">��ɫ���Ȳ�</option>
      					<option value="��ʳ">��ʳ</option>
      					<option value="�ز�">�ز�</option>
     					 <option value="����">����</option>
     					 <option value="����">����</option>
   					 </select>
				</div>
				<div class="form-group">
					 <label for="foodprice">��Ʒ����</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="foodprice" name="foodprice" type="text"  placeholder="��15��20"/>
				</div>
				<div class="form-group">
					 <label for="fooddescribe">��Ʒ����</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" class="form-control" id="fooddescribe" name="fooddescribe" maxlength="100" placeholder="������100�ַ�"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile">ѡ��ͼƬ</label>
					 <input style="background:transparent; border:0; border-bottom:1px solid gray" id="exampleInputFile" name="foodpath" type="file" />													 					
				</div>
				<input class="btn btn-block btn-success" type="submit" value="�ύ">
				
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
</body>
</html>