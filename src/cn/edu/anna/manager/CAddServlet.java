package cn.edu.anna.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CAddServlet",urlPatterns = {"/m/add_college.do"})
public class CAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String college=request.getParameter("college");
        String dintro=request.getParameter("dintro");
        CollegeDao collegeDao=new CollegeDao();
        collegeDao.add(college,dintro);
        ArrayList<College> colleges=collegeDao.list();
        request.getSession().removeAttribute("college_list");
        request.getSession().setAttribute("college_list",colleges);
        request.getRequestDispatcher("college.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
