package cn.edu.anna.stu;

import cn.edu.anna.manager.College;
import cn.edu.anna.manager.CollegeDao;
import cn.edu.anna.manager.Teacher;
import cn.edu.anna.manager.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet",urlPatterns = {"/s_login.do"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sid=request.getParameter("sid");
        String spasw=request.getParameter("spasw");
        MessageDao messageDao=new MessageDao();
        ArrayList<Message> messageArrayList=messageDao.list();
        int flag=0;
        StudentDao studentDao=new StudentDao();
        flag=studentDao.loginCheck(sid,spasw);
        if (flag==1){
            TeacherDao teacherDao=new TeacherDao();
            System.out.println("teacher start");
            ArrayList<Teacher> teachers=teacherDao.list();
            System.out.println("teacher end");
            System.out.println("college start");
            CollegeDao collegeDao=new CollegeDao();
            ArrayList<College> colleges=collegeDao.list();
            System.out.println("college end");
            System.out.println("course start");
            CourseDao courseDao=new CourseDao();
            ArrayList<Course> courseArrayList=courseDao.list();
            System.out.println("course end");
            request.getSession().setAttribute("college_list",colleges);
            System.out.println("course end");
            request.getSession().setAttribute("teacher_list",teachers);
            System.out.println("course end");
            request.getSession().setAttribute("course_list",courseArrayList);
            System.out.println("course end");
            Student student=studentDao.setAll(sid);
            request.getSession().setAttribute("message_list",messageArrayList);
            request.getSession().setAttribute("cur_user",student);
            System.out.println("course end");
            response.sendRedirect("student/home.jsp");
        }else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
