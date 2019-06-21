<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/20
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>添加教师</title>
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
                    <a  href="college.jsp"><i class="fa fa-circle-o"></i> 学院</a>
                </li>
                <li>
                    <a class="active-menu" href="teacher.jsp"><i class="fa fa-user "></i> 教师</a>
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
                        添加 <small></small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-9">
                                    <form action="add_teacher.do" method="post" role="form">
                                        <div class="form-group">
                                            <label>教师姓名</label>
                                            <input name="tname"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>教工号(教师密码)</label>
                                            <input name="tid"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>教师职称</label>
                                            <input name="ttitle" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label class="select">所属学院
                                                <select name="tdept" id="college" >
                                                    <c:forEach var="row" items="${college_list}">
                                                        <option><c:out value="${row.college}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>教师简介</label>
                                            <textarea name="tintro" class="form-control" rows="3"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-default">确认</button>
                                        <button onclick="window.location.href='teacher.jsp'" class="btn btn-default">取消</button>


                                    </form>
                                </div>

                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

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
