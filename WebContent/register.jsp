<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

       <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/simple-blog.min.css" rel="stylesheet">
  
<title>用户注册</title>
<script>
   function mycheck(){
      if(document.all("user.password").value != document.all("again").value){
         alert("两次输入的密码不正确，请更正。");
         return false;
      }else
      {
         return true;
      }
   }
</script>
</head>
<body>

<div class="container">
<div class="row">
<form action="<c:url value="/doregister" />" method="post" onsubmit="return mycheck()">
<c:if test="${!empty errorMsg}">
   <div style="color=red">${errorMsg}</div>
</c:if>

<div class="col-lg-8 col-md-10">
    <h1>用户注册</h1>
    <hr/>
    <div class="row control-group">
       <div class="form-group col-md-8 floating-label-form-group controls">
        
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username:"/>
       </div>
    </div>

    <div class="row control-group">
       <div class="form-group col-md-8 floating-label-form-group controls">
            <label for="password">密码</label>
            <input type="password" class="form-control"  name="password" placeholder="Enter Password:"/>
        </div>
    </div>
    
    <div class="row control-group">
       <div class="form-group col-md-8 floating-label-form-group controls">
            <label for="password">Password:</label>
            <input type="password" class="form-control" name="again" placeholder="Enter Password Again:"/>
        </div>
    </div>
        
        <div class="row control-group">
            <button type="submit" class="btn-sm btn-success">注册</button>
            <button type="reset" class="btn-sm btn-success">重置</button>
        </div>
    
</div>
</form>

  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>

  <!-- Custom Theme JavaScript -->
  <script src="js/simple-blog.js"></script>


</body>
</html>
