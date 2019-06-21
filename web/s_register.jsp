<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/15
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

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
        <div class="col-md-4 col-md-offset-4">


            <!-- Start Sign In Form -->
            <form action="s_register.do" method="post" name="signup" class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>学生注册</h2>
                <div class="form-group">
                    <label for="sname" class="sr-only">姓名</label>
                    <input type="text" class="form-control" name="sname" id="sname" placeholder="姓名" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="sid" class="sr-only">学号</label>
                    <input type="text" class="form-control" name="sid" id="sid" placeholder="学号" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="sdept" >学院</label>
                    <select class="form-control" id="sdept" name="sdept">
                        <option>光电信息与计算机工程学院</option>
                        <option>马克思主义学院</option>
                        <option>能源与动力工程学院</option>
                        <option>管理学院</option>
                        <option>理学院</option>
                        <option>环境与建筑学院</option>
                        <option>材料科学与工程学院</option>
                        <option>机械工程学院</option>
                        <option>医疗器械与视食品学院</option>
                        <option>外语学院</option>
                        <option>医疗器械与视食品学院</option>
                        <option>出版印刷与艺术设计学院</option>
                        <option>中英国际学院</option>
                        <option>上海汉堡国际工程学院</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="spasw" class="sr-only">密码</label>
                    <input type="password" class="form-control" name="spasw" id="spasw" placeholder="密码" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="re-spasw" class="sr-only">确认密码</label>
                    <input type="password" class="form-control" id="re-spasw" onblur="check_pasw()" placeholder="确认密码" autocomplete="off">
                    <span id="divpsaw"></span>
                </div>
                <div class="form-group">
                    <p>已注册? <a href="index.jsp">登录</a></p>
                </div>
                <div class="form-group">
                    <input type="submit" value="注册" class="btn btn-primary">
                </div>
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>

</div>

<script>
    function check_pasw(){
        var pw1=document.getElementById('spasw').value;
        var pw2=document.getElementById('re-spasw').value;
        if(pw1.length<1)
        {
            divpsaw.innerHTML='<font class="tips_false" color="red">请输入密码</font>';
        }else if(pw1!=pw2){
            divpsaw.innerHTML='<font class="tips_true" color="red">两次输入不一致</font>';
        }
    }
</script>
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

