package cn.edu.anna.teacher;

import cn.edu.anna.manager.Teacher;
import cn.edu.anna.manager.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TChangePaswServlet",urlPatterns = {"/teacher/change_tpasw.do"})
public class TChangePaswServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pasw=request.getParameter("pasw");
        Teacher teacher=(Teacher) request.getSession().getAttribute("cur_teacher");
        String tid=teacher.getTid();
        TeacherDao teacherDao=new TeacherDao();
        teacherDao.changePasw(tid,pasw);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
