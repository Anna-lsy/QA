package cn.edu.anna.teacher;

import cn.edu.anna.manager.Teacher;
import cn.edu.anna.stu.Message;
import cn.edu.anna.stu.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "HasLookedServlet",urlPatterns = {"/teacher/t_haslooked.do"})
public class HasLookedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String mid=request.getParameter("mid");
        String cname=request.getParameter("cname");
        int flag=Integer.parseInt(request.getParameter("flag"));
        MessageDao messageDao=new MessageDao();
        messageDao.t_haslooked(mid);
        ArrayList<Message> messageArrayList=messageDao.list();
        request.getSession().removeAttribute("message_list");
        request.getSession().setAttribute("message_list",messageArrayList);
        request.getRequestDispatcher("message_detail.jsp?flag="+flag+"&mid="+mid+"&cname="+cname).forward(request,response);
    }
}
