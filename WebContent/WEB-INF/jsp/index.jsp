<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Simple Blog</title>

  <!-- me.ico -->
  <link rel="icon" href="img/me.ico" type="image/x-ico"/>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="css/simple-blog.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

</head>
<body>
  <!-- header 导航栏 -->
  <%@ include file="header.html" %>
  <!-- jsp:include page="header.html" flush="false" 这种方式有问题，还不知道为什么 -->

  <!-- Page Header -->
  <!-- Set your background image for this header on the line below. -->
  <header class="intro-header" style="background-image: url('img/home-bg.jpg')">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
          <div class="site-heading">
            <h1>Simple Blog</h1>
            <hr class="small">
            <span class="subheading">一个简单的博客</span>
          </div>
        </div>
      </div>
    </div>
  </header>



  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <!--
          添加style="word-break:break-all;"为了解决BootStrap中div内容如果是英文的话，无法自动换行
          参考连接：http://www.jb51.net/css/22839.html
      -->
      <!-- 标签云 -->
      <div class="col-lg-2 col-md-2" style="word-break:break-all;">
        <div>
          <div id='tag-cloud'>
           <h3>用户</h3>
           <c:if test="${empty USER_CONTEXT.username}">
              <a href="<c:url value="/login.jsp"/>">登陆</a><br/>
              <a href="<c:url value="/register.jsp"/>">注册</a><br/>
            </c:if>
            <c:if test="${!empty USER_CONTEXT.username}">
   				${USER_CONTEXT.username} <br/>
   				<a href="<c:url value="/dologout"/>">注销</a>
		    </c:if>
			<br/>
            <h3>导航栏</h3>
           
            <a href="<c:url value="/category?category=Java"/>">Java</a> <br/>
            <a href="<c:url value="/category?category=C/C++"/>">C/C++</a> <br/>
            <a href="<c:url value="/category?category=Python"/>">Python</a> <br/>
            <a href="<c:url value="/category?category=OS"/>">OS</a> <br/>
            <a href="<c:url value="/category?category=网络"/>">网络</a> <br/>
            <a href="<c:url value="/category?category=框架"/>">框架</a> <br/>
            <a href="<c:url value="/category?category=生活"/>">生活</a> <br/>
            <!--
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form> -->
          </div>
        </div>
      </div>

      <div class="col-lg-8 col-md-10">

        <c:forEach var="blog" items="${blogs}">
          <div class="post-preview">
            <a href="<c:url value="/blog?p=${blog.id}"/>">
              <h2 class="post-title">
                  ${blog.title}
              </h2>
            </a>
            <p class="post-preview">
                ${blog.preview}
            </p>
            <p class="post-meta">Posted by <a href="#">${blog.author}</a> on ${blog.date}</p>
          </div>
          <hr>
        </c:forEach>

        <!--
        <div class="post-preview">
          <a href="post.html">
            <h2 class="post-title">
              Blog Title 1
            </h2>
          </a>
          <p class="post-preview">
            blog preview 1
          </p>
          <p class="post-meta">Posted by <a href="#">luoxn28</a> on September 24, 2015</p>
        </div>
        <hr>-->

        <!-- Pager -->
        <ul class="pager">
          <li class="next">
            <a href="<c:url value="/blog?p=0"/>">More Blogs &rarr;</a>
          </li>
        </ul>
      </div>
    </div>

    <hr/>
    <!-- 留言板 -->
    留言板<br/>
    <c:forEach var="message" items="${messages}">
      <div class="col-lg-3 col-md-4 bg-info">
        <label>${message.author}</label> <br/>
        ${message.content} <br/>
        ${message.date}
      </div>
    </c:forEach>

    <div class="col-lg-12 col-md-12">
      <form action="<c:url value="/message"/>" method="post" onsubmit="return validate_message(this)">
        <div class="row control-group">
          <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>昵称</label> <!-- 未显示 floating-label-form-group 控制-->
            <input type="text" class="form-control" name="author" placeholder="昵称"/>
          </div>
        </div>
        <div class="row control-group">
          <div class="form-group col-xs-12 floating-label-form-group controls">
            <label>留言</label>
            <input type="text" class="form-control" name="content" placeholder="留言"/>
          </div>
        </div>
        <input type="submit" value="提交"/>
      </form>
    </div>

  </div>

  <hr/>

  <!-- Footer 网页底部 -->
  <%@ include file="footer.html" %>

  <!-- jQuery -->
  <script src="js/jquery.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="js/bootstrap.min.js"></script>

  <!-- Custom Theme JavaScript -->
  <script src="js/simple-blog.js"></script>

</body>
</html>