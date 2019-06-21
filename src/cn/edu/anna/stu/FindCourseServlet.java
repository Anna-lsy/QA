package cn.edu.anna.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FindCourseServlet",urlPatterns = {"/student/find_course.do"})
public class FindCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        CourseDao courseDao=new CourseDao();
        ArrayList<Course> courseArrayList=courseDao.findCourselist(tid);
        String tname=courseArrayList.get(1).getTname();
        request.setAttribute("t_course_list",courseArrayList);
        request.setAttribute("tname",tname);
        request.getRequestDispatcher("/student/t_courselist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
