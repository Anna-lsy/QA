<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/12
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>学生登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
  <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

  <!-- Facebook and Twitter integration -->
  <meta property="og:title" content=""/>
  <meta property="og:image" content=""/>
  <meta property="og:url" content=""/>
  <meta property="og:site_name" content=""/>
  <meta property="og:description" content=""/>
  <meta name="twitter:title" content="" />
  <meta name="twitter:image" content="" />
  <meta name="twitter:url" content="" />
  <meta name="twitter:card" content="" />

  <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
  <link rel="shortcut icon" href="favicon.ico">

  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/style.css">


  <!-- Modernizr JS -->
  <script src="js/modernizr-2.6.2.min.js"></script>
  <!-- FOR IE9 below -->
  <!--[if lt IE 9]>
  <script src="js/respond.min.js"></script>
  <![endif]-->

</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <ul class="menu">
        <li class="active"><a href="index.jsp">学生</a></li>
        <li><a href="t_sign.jsp">教师</a></li>
        <li><a href="m_sign.jsp">管理员</a></li>
      </ul>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4 col-md-offset-4">


      <!-- Start Sign In Form -->
      <form action="s_login.do" method="post" class="fh5co-form animate-box" >
        <h2>学生登录</h2>
        <div class="form-group">
          <label for="sid" class="sr-only">学号</label>
          <input type="text" class="form-control" name="sid" id="sid" placeholder="学号" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="spasw" class="sr-only">密码</label>
          <input type="password" class="form-control" name="spasw" id="spasw" placeholder="密码" autocomplete="off">
        </div>
        <div class="form-group">
          <label for="remember"><input type="checkbox" id="remember"> 记住我</label>
        </div>
        <div class="form-group">
          <p>还未注册? <a href="s_register.jsp">注册</a> | <a href="#">忘记密码?</a></p>
        </div>
        <div class="form-group">
          <input type="submit" value="登录" class="btn btn-primary">
        </div>
      </form>
      <!-- END Sign In Form -->

    </div>
  </div>
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="js/main.js"></script>


</body>
</html>


