<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/17
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/14
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>Courses</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/edua-icons.css">
    <link rel="stylesheet" type="text/css" href="css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="css/owl.transitions.css">
    <link rel="stylesheet" type="text/css" href="css/cubeportfolio.min.css">
    <link rel="stylesheet" type="text/css" href="css/settings.css">
    <link rel="stylesheet" type="text/css" href="css/bootsnav.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/loader.css">

    <link rel="icon" href="images/favicon.png">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!--Header-->
<header>
    <nav class="navbar navbar-default navbar-fixed white no-background bootsnav">
        <div class="container">
            <div class="search_btn btn_common"><i class="icon-icons185"></i></div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="home.jsp"><img src="images/logo-white.png" alt="logo" class="logo logo-display">
                    <img src="images/logo.png" class="logo logo-scrolled" alt="">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOut">
                    <li><a href="home.jsp">首页</a></li>
                    <li><a href="college.jsp">学院</a></li>
                    <li><a href="page.do">教师</a></li>
                    <li><a href="my_message.jsp">我的留言</a></li>
                    <li><a href="add_message.jsp">添加留言</a></li>
                    <li><a href="user.jsp">欢迎${cur_user.sid}</a></li>
                    <li><a href="logout.do">退出</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>


<!--Search-->
<div id="search">
    <button type="button" class="close">×</button>
    <form>
        <input type="search" value="" placeholder="Search here...."  required/>
        <button type="submit" class="btn btn_common blue">Search</button>
    </form>
</div>

<!--Page Header-->
<section class="page_header padding-top">
    <div class="container">
        <div class="row">
            <div class="col-md-12 page-content">
                <c:forEach items="${college_list}" var="row">
                    <c:if test="${row.college==param.college}">
                        <h1><c:out value="${row.college}"/></h1>
                        <p><c:out value="${row.dintro}"/></p>
                    </c:if>
                </c:forEach>
                <div class="page_nav">
                    <span>你的位置:</span> <a href="home.jsp">首页</a> <span><i class="fa fa-angle-double-right"></i>${param.college}课程</span>
                </div>
            </div>
        </div>
    </div>
</section>
<!--Page Header-->



<!-- course -->
<section id="course_all" class="padding-bottom">
    <div class="container">
        <div class="row">
            <c:forEach var="row" items="${course_list}">
                <c:if test="${row.cdept==param.college}">
                    <div class="col-sm-6 col-md-4">
                        <div class="course margin_top wow fadeIn" data-wow-delay="400ms">
                            <h3 class="bottom10"><a href="#"><c:out value="${row.cname}"/></a></h3>
                            <p class="bottom20 line-limit-length"><c:out value="${row.content}"/></p>
                            <a class="btn_common yellow border_radius" href="message_list.jsp?cid=${row.cid}&cname=${row.cname}">查看留言</a>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</section>
<!-- course ends -->


<script type="text/javascript" src="js/footer.js"></script>



<script src="js/jquery-2.2.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootsnav.js"></script>
<script src="js/jquery.appear.js"></script>
<script src="js/jquery-countTo.js"></script>
<script src="js/jquery.parallax-1.1.3.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.cubeportfolio.min.js"></script>
<script src="js/jquery.themepunch.tools.min.js"></script>
<script src="js/jquery.themepunch.revolution.min.js"></script>
<script src="js/revolution.extension.layeranimation.min.js"></script>
<script src="js/revolution.extension.navigation.min.js"></script>
<script src="js/revolution.extension.parallax.min.js"></script>
<script src="js/revolution.extension.slideanims.min.js"></script>
<script src="js/revolution.extension.video.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/functions.js"></script>

</body>
</html>

