<%--
  Created by IntelliJ IDEA.
  User: LSY
  Date: 2018/12/24
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>首页</title>
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
                    <a href="course_list.jsp"><i class="fa fa-book"></i> 我的课程</a>
                </li>
                <li>
                    <a class="active-menu" href="all_not_ans.jsp"><i class="fa fa-comment-o"></i> 未回答留言</a>
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
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">

                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>留言者</th>
                                        <th>留言标题</th>
                                        <th>留言内容</th>
                                        <th>留言时间</th>
                                        <th>留言课程</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="row" items="${message_list}">
                                        <c:if test="${row.flag==0}">
                                            <c:forEach var="c" items="${teacher_course}">
                                                <c:if test="${row.mcourse==c.cname}">
                                                    <tr class="odd gradeX">
                                                        <td>${row.sid}</td>
                                                        <td>${row.mtitle}</td>
                                                        <td>${row.qu}</td>
                                                        <td>${row.mtime}</td>
                                                        <td>${row.mcourse}</td>
                                                        <td><a href="message_detail.jsp?mid=${row.mid}&flag=${row.flag}" class="btn btn-info">查看</a></td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. ROW  -->
        </div>
    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>