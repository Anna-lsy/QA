package cn.edu.anna.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TDeleteServlet",urlPatterns = {"/m/delete_teacher.do"})
public class TDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        TeacherDao teacherDao=new TeacherDao();
        teacherDao.delete(tid);
        ArrayList<Teacher> teachers=teacherDao.list();
        request.getSession().removeAttribute("teacher_list");
        request.getSession().setAttribute("teacher_list",teachers);
        request.getRequestDispatcher("teacher.jsp").forward(request,response);
    }
}
