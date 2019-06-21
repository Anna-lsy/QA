package cn.edu.anna.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SHasLookedServlet",urlPatterns = {"/student/s_haslooked.do"})
public class SHasLookedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String mid=request.getParameter("mid");
        MessageDao messageDao=new MessageDao();
        messageDao.s_haslooked(mid);
        ArrayList<Message> messageArrayList=messageDao.list();
        request.getSession().removeAttribute("message_list");
        request.getSession().setAttribute("message_list",messageArrayList);
        request.getRequestDispatcher("message_detail.jsp?mid="+mid).forward(request,response);
    }
}
