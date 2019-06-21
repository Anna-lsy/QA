package cn.edu.anna.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TUpdateServlet",urlPatterns = {"/m/update_teacher.do"})
public class TUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String tid=request.getParameter("tid");
        String tname=request.getParameter("tname");
        String ttitle=request.getParameter("ttitle");
        String tdept=request.getParameter("tdept");
        String tintro=request.getParameter("tintro");
        TeacherDao teacherDao=new TeacherDao();
        teacherDao.update(tid,tname,ttitle,tintro,tdept);
        ArrayList<Teacher> teachers=teacherDao.list();
        request.getSession().removeAttribute("teacher_list");
        request.getSession().setAttribute("teacher_list",teachers);
        request.getRequestDispatcher("teacher.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
