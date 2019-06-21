<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/17
  Time: 9:25 AM
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
    <title>教师</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/edua-icons.css">
    <link rel="stylesheet" type="text/css" href="css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="css/owl.transitions.css">
    <link rel="stylesheet" type="text/css" href="css/settings.css">
    <link rel="stylesheet" type="text/css" href="css/bootsnav.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/loader.css">

    <link rel="icon" href="images/favicon.png">

    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <!--[endif]-->
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
                <!-- <h1>学院</h1> -->
                <!-- <p>We offer the most complete house renovating services in the country</p> -->
                <div class="page_nav">
                    <span>你的位置:</span> <a href="home.jsp">首页</a> <span><i class="fa fa-angle-double-right"></i>教师</span>
                </div>
            </div>
        </div>
    </div>
</section>
<!--Page Header-->


<!--teacher-->
<section id="shop" class="padding">
    <div class="container">
        <div class="row">
            <c:forEach var="row" items="${teacher_list}">
                <div class="col-md-3 col-sm-6 margin10 bottom15 wow fadeIn" data-wow-delay="300ms">
                    <div class="shopping_box">
                        <div class="image">
                            <img src="images/default.png" alt="Edua" class="img-responsive border-radius">
                            <form action="find_course.do" method="post">
                                <input type="text" value="${row.tid}" name="tid" style="display:none" >
                                <div class="overlay border_radius">
                                    <button type="submit" class="btn_common yellow border_radius btn-cart" >查看课程</button>
                                </div>
                            </form>
                        </div>
                        <div class="shop_content text-center">
                            <h4><c:out value="${row.tname}"/></h4>
                            <p><c:out value="${row.tdept}"/></p>
                            <h4 class="t_title"><c:out value="${row.ttitle}"/></h4>
                        </div>

                    </div>
                </div>
            </c:forEach>
            <%--<div class="pager_nav wow fadeIn" data-wow-delay="600ms">--%>
                <%--<ul class="pagination">--%>
                    <%--<li <c:if test="${!page.isHasPreviouse()}">class="disabled"</c:if>>--%>
                        <%--<a href="page.do?page.start=0" aria-label="Previous">--%>
                            <%--<span >&laquo;</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>

                    <%--<li <c:if test="${!page.isHasPreviouse()}">class="disabled"</c:if>>--%>
                        <%--<a href="page.do?page.start=${page.start-8}" aria-label="Previous">--%>
                            <%--<span>‹</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>

                    <%--<c:forEach begin="0" end="${page.getTotalPage()-1}" varStatus="status">--%>

                        <%--<c:if test="${status.count*page.count-page.start<=24 && status.count*page.count-page.start>=-8}">--%>
                            <%--<li <c:if test="${status.index*8==page.start}">class="disabled"</c:if>>--%>
                                <%--<a--%>
                                        <%--href="page.do?page.start=${status.index*page.count}"--%>
                                        <%--<c:if test="${status.index*page.count==page.start}">class="current"</c:if>--%>
                                <%-->${status.count}</a>--%>
                            <%--</li>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>

                    <%--<li <c:if test="${!page.isHasNext()}">class="disabled"</c:if>>--%>
                        <%--<a href="page.do?page.start=${page.start+page.count}">--%>
                            <%--<span>›</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li <c:if test="${!page.isHasNext()}">class="disabled"</c:if>>--%>
                        <%--<a href="page.do?page.start=${page.last}">--%>
                            <%--<span>»</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<form action="page.do">--%>
                        <%--<input type="text" name="page_num" >--%>
                        <%--<button type="submit" class="btn_common yellow border_radius" id="btn_submit">跳转</button>--%>
                    <%--</form>--%>

                <%--</ul>--%>
            <%--</div>--%>
        </div>
    </div>

</section>
<!--teacher-->
<%--分页--%>
<nav class="pageDIV">
    <ul class="pagination">

    </ul>
</nav>


<script>
    $(function () {
        $("ul.pagination li.disabled a").click(function () {
            return false;
        });
    });
</script>

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
