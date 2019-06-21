<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/19
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>学院详情</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="user.jsp"><i class="fa fa-user-o" aria-hidden="true"></i> <strong>Manager </strong></a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li>
                <a href="m_logout.do"><i class="fa fa-sign-out"></i> 退出</a>
            </li>

            <!-- /.dropdown -->
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a  href="home.jsp"><i class="fa fa-home"></i> 首页</a>
                </li>

                <li>
                    <a class="active-menu" href="college.jsp"><i class="fa fa-circle-o"></i> 学院</a>
                </li>
                <li>
                    <a href="teacher.jsp"><i class="fa fa-user "></i> 教师</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        学院详情 <small></small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <c:forEach items="${college_list}" var="row">
                    <c:if test="${row.did==param.did}">
                        <div class="col-md-9 col-sm-9">
                            <div class="well">
                                <h4>${row.college}</h4>
                                <p>${row.dintro}</p>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <a href="change_college.jsp?did=${param.did}" class="btn btn-info">修改</a>
            <a href="delete_college.do?did=${param.did}" class="btn btn-info">删除</a>
            <a href="college.jsp" class="btn btn-info">返回</a>
            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
