package cn.edu.anna.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeletServlet",urlPatterns = {"/student/delete_message.do"})
public class DeletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String mid=request.getParameter("mid");
        System.out.println(mid);
        MessageDao messageDao=new MessageDao();
        messageDao.delete(mid);
        ArrayList<Message> messageArrayList=messageDao.list();
        request.getSession().removeAttribute("message_list");
        request.getSession().setAttribute("message_list",messageArrayList);
        request.getRequestDispatcher("/student/update_success.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
