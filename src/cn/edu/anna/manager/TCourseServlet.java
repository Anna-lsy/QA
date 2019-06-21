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

@WebServlet(name = "TCourseServlet",urlPatterns = {"/m/teacher_course.do"})
public class TCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        String tname=request.getParameter("tname");
        CourseDao courseDao=new CourseDao();
        ArrayList<Course> courseArrayList=courseDao.findCourselist(tid);
        request.setAttribute("teacher_course",courseArrayList);
        request.setAttribute("tname",tname);
        request.getRequestDispatcher("t_courselist.jsp").forward(request,response);
    }
}
