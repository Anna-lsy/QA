package cn.edu.anna.manager;

import cn.edu.anna.stu.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MLoginServlet",urlPatterns = {"/m_login.do"})
public class MLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String mid=request.getParameter("mid");
        String mpasw=request.getParameter("mpasw");
        int flag=0;
        ManagerDao managerDao=new ManagerDao();
        flag=managerDao.check(mid,mpasw);
        if (flag==1){
            Manager manager=new Manager();
            manager.setManager(mid);
            manager.setMpasw(mpasw);
            TeacherDao teacherDao=new TeacherDao();
            ArrayList<Teacher> teachers=teacherDao.list();
            CollegeDao collegeDao=new CollegeDao();
            ArrayList<College> colleges=collegeDao.list();
            CourseDao courseDao=new CourseDao();
            ArrayList<Course> courseArrayList=courseDao.list();
            request.getSession().setAttribute("cur_user",manager);
            request.getSession().setAttribute("college_list",colleges);
            request.getSession().setAttribute("teacher_list",teachers);
            request.getSession().setAttribute("course_list",courseArrayList);
            response.sendRedirect("m/home.jsp");
        }else {
            request.getRequestDispatcher("m_sign.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
