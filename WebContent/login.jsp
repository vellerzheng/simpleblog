<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


      <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/simple-blog.min.css" rel="stylesheet">
  
<title>用户登录</title>

</head>
<body>

<c:if test="${!empty errorMsg}">
  <div style="color:red">${errorMsg}</div>
</c:if>

  <div class="container">
    <div class="row">
	<form action="<c:url value="/dologin"/>" method="post"> 
<!--  <form action="${context}/login/doLogin.html" method="post">
-->

		<div class="col-lg-8 col-md-10">
    	<h1>用户登陆</h1>
    	<hr/>
    	<form:form action="<c:url value="/dologin"/>" method="post">
        	<div class="row control-group">
        	<div class="form-group col-md-8 floating-label-form-group controls">
            	<label for="username">User Name:</label>
            	<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username:"/>
            	</div>
        	</div>

        		<div class="row control-group">
        		  <div class="form-group col-md-8 floating-label-form-group controls">
			        <label for="password">Password:</label>
			        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password:"/>
			      </div>
			       </br>
			   	</div>
			   	<div class="row control-group">
			   	
			        	<button type="submit" class="btn-sm btn-success">登陆</button>
			        	<button type="reset" class="btn-sm btn-success">重置</button>
			       
			   	</div>
    	</form:form>
		</div>
	   

  </form>
  </div>
</div>

  <!-- jQuery -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>

  <!-- Custom Theme JavaScript -->
  <script src="js/simple-blog.js"></script>
  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 -->
</body>
</html>
