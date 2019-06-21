<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/17
  Time: 11:14 AM
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
    <title>留言列表</title>
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
                <c:forEach items="${course_list}" var="row">
                    <c:if test="${row.cid==param.cid}">
                        <h1><c:out value="${row.cname}"/></h1>
                        <p><c:out value="${row.content}"/></p>
                    </c:if>
                </c:forEach>
                <div class="page_nav">
                    <span>你的位置:</span> <a href="home.jsp">首页</a> <span><i class="fa fa-angle-double-right"></i>${param.cname}</span>
                </div>
            </div>
        </div>
    </div>
</section>
<!--Page Header-->


<!--BLOG SECTION-->
<section id="blog" class="padding">
    <div class="container">
        <h2 class="hidden">Our Blog</h2>
        <div class="row">
            <div class="row">
                <c:forEach var="row" items="${message_list}">
                    <c:if test="${row.mcourse==param.cname}">
                        <div class="col-md-6 col-sm-6  heading_space">
                            <h3><c:out value="${row.mtitle}"/></h3>
                            <ul class="comment margin10">
                                <li><a href="#."><c:out value="${row.mtime}"/></a></li>
                                <c:if test="${row.flag==1}">
                                    <li><a href="#."><i class="icon-comment"></i> 已解答</a></li>
                                </c:if>
                                <c:if test="${row.flag==0}">
                                    <li><a href="#."><i class="icon-comment"></i> 未解答</a></li>
                                </c:if>
                            </ul>
                            <p class="margin10 line-limit-length"><c:out value="${row.qu}"/></p>
                            <a class=" btn_common btn_border margin10 border_radius" href="message_detail.jsp?mid=${row.mid}">查看</a>
                        </div>
                    </c:if>
                </c:forEach>

            </div>

        </div>
    </div>
</section>
<!--BLOG SECTION-->


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
