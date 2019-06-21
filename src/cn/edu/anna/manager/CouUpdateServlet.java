package cn.edu.anna.manager;

import cn.edu.anna.stu.Course;
import cn.edu.anna.stu.CourseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CouUpdateServlet",urlPatterns = {"/m/update_course.do"})
public class CouUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String cid=request.getParameter("cid");
        String cname=request.getParameter("cname");
        String cdept=request.getParameter("cdept");
        String content=request.getParameter("content");
        CourseDao courseDao=new CourseDao();
        courseDao.update(cid,cname,content,cdept);
        ArrayList<Course> courseArrayList=courseDao.list();
        request.getSession().removeAttribute("course_list");
        request.getSession().setAttribute("course_list",courseArrayList);
        request.getRequestDispatcher("c_courselist.jsp?college="+cdept).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
