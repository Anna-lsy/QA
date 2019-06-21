package cn.edu.anna.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SChangePaswServlet",urlPatterns = {"/student/change_spasw.do"})
public class SChangePaswServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String new_spasw=request.getParameter("new_spasw");
        Student student=(Student) request.getSession().getAttribute("cur_user");
        String sid=student.getSid();
        StudentDao studentDao=new StudentDao();
        studentDao.changePasw(new_spasw,sid);
        request.getRequestDispatcher("update_success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
