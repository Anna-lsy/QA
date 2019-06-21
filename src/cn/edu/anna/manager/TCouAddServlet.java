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

@WebServlet(name = "TCouAddServlet",urlPatterns = {"/m/add_t_course.do"})
public class TCouAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        String cid;
        String cname=request.getParameter("cname");
        CourseDao courseDao=new CourseDao();
        cid=courseDao.findID(cname);
        System.out.println(cid);
        courseDao.add_t_course(cid,tid);
        ArrayList<Course> courseArrayList2=courseDao.findCourselist(tid);
        request.setAttribute("teacher_course",courseArrayList2);
        request.getRequestDispatcher("t_courselist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
