<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/20
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>留言</title>
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
            <a class="navbar-brand" href="user.jsp"><i class="fa fa-user-o" aria-hidden="true"></i> <strong>${cur_teacher.tname}</strong></a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li>
                <a href="t_logout.do"><i class="fa fa-sign-out"></i> 退出</a>
            </li>>

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
                    <a href="course_list.jsp"><i class="fa fa-book"></i> 我的课程</a>
                </li>
                <li>
                    <a href="all_not_ans.jsp"><i class="fa fa-comment-o"></i> 未回答留言</a>
                </li>
                <li>
                    <a href="my_ans.jsp"><i class="fa fa-comments-o"></i> 我的回答</a>
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
                        留言 <small></small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <c:forEach items="${message_list}" var="row">
                    <c:if test="${row.mid==param.mid}">
                        <div class="col-md-9 col-sm-9">
                            <div class="well">
                                <h4>${row.mtitle}</h4>
                                <p>留言者:${row.sid}</p>
                                <p>留言时间:${row.mtime}</p>
                                <p>课程:${row.mcourse}</p>
                                <p>学院:${row.mcollege}</p>
                                <p>内容:${row.qu}</p>
                                <c:if test="${(row.s_path!=null)&&(!empty row.s_path)}">
                                    <img src="/upload/${row.s_path}" />
                                </c:if>
                                <c:if test="${row.flag==1}">
                                    <li><a href="#."><i class="fa fa-comment"></i> 已解答</a></li>
                                    <p>回答老师:${row.tname}</p>
                                    <p>回答:${row.ans}</p>
                                    <c:if test="${(row.t_path!=null)&&(!empty row.t_path)}">
                                        <img src="/upload/${row.t_path}" />
                                    </c:if>
                                    <p>回答时间:${row.atime}</p>
                                </c:if>
                                <c:if test="${row.flag==0}">
                                    <li><a href="#."><i class="fa fa-comment"></i> 未解答</a></li>
                                </c:if>
                            </div>
                        </div>
                        <c:if test="${cur_teacher.tid==row.tid}">
                            <a href="change_ans.jsp?mid=${param.mid}&cname=${param.cname}" class="btn btn-info">修改回答</a>
                        </c:if>
                    </c:if>
                </c:forEach>
                <c:if test="${param.flag==0}">
                    <br>
                    <a href="answer.jsp?mid=${param.mid}&cname=${param.cname}" class="btn btn-info">回答</a>
                </c:if>
                <br>
                <c:if test="${param.my==0}">
                    <br>
                    <a href="all_message.jsp?cname=${param.cname}" class="btn btn-info">返回</a>
                </c:if>
                <c:if test="${param.my==1}">
                    <br>
                    <a href="my_ans.jsp?cname=${param.cname}" class="btn btn-info">返回</a>
                </c:if>
            </div>

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