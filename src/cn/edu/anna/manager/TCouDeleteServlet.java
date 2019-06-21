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

@WebServlet(name = "TCouDeleteServlet",urlPatterns = {"/m/delete_t_course.do"})
public class TCouDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        String cid=request.getParameter("cid");
        CourseDao courseDao=new CourseDao();
        courseDao.delete_t_course(cid,tid);
        courseDao.delete(cid);
        ArrayList<Course> courseArrayList=courseDao.list();
        ArrayList<Course> courseArrayList2=courseDao.findCourselist(tid);
        request.getSession().removeAttribute("course_list");
        request.getSession().setAttribute("course_list",courseArrayList);
        request.setAttribute("teacher_course",courseArrayList2);
        request.getRequestDispatcher("t_courselist.jsp").forward(request,response);
    }
}
