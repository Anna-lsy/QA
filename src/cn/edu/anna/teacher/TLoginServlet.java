package cn.edu.anna.teacher;

import cn.edu.anna.manager.Teacher;
import cn.edu.anna.manager.TeacherDao;
import cn.edu.anna.stu.Course;
import cn.edu.anna.stu.CourseDao;
import cn.edu.anna.stu.Message;
import cn.edu.anna.stu.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TLoginServlet",urlPatterns = {"/t_login.do"})
public class TLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        String tpasw=request.getParameter("tpasw");
        TeacherDao teacherDao=new TeacherDao();
        int flag=0;
        flag=teacherDao.check(tid,tpasw);
        System.out.println(flag);
        if (flag==1){
            Teacher teacher=teacherDao.getTeacherMessage(tid);
            request.getSession().setAttribute("cur_teacher",teacher);
            CourseDao courseDao=new CourseDao();
            ArrayList<Course> courseArrayList=courseDao.findCourselist(tid);
            MessageDao messageDao=new MessageDao();
            ArrayList<Message> messageArrayList=messageDao.list();
            request.getSession().setAttribute("teacher_course",courseArrayList);
            request.getSession().setAttribute("message_list",messageArrayList);
            response.sendRedirect("teacher/home.jsp");
        }else {
            request.getRequestDispatcher("t_sign.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
