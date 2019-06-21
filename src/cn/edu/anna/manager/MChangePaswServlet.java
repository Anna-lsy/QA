package cn.edu.anna.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MChangePaswServlet",urlPatterns = {"/m/change_mpasw.do"})

public class MChangePaswServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pasw=request.getParameter("pasw");
        Manager manager=(Manager) request.getSession().getAttribute("cur_user");
        String mid=manager.getManager();
        ManagerDao managerDao=new ManagerDao();
        managerDao.changePasw(mid,pasw);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
