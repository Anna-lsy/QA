package cn.edu.anna.stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/s_register.do"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sid=request.getParameter("sid");
        String spasw=request.getParameter("spasw");
        String sdept=request.getParameter("sdept");
        String sname=request.getParameter("sname");
        StudentDao studentDao=new StudentDao();
        int flag=0;
        flag=studentDao.registerCheck(sid,spasw,sdept,sname);
        if (flag==1){
            request.getRequestDispatcher("/re_fail.html").forward(request,response);
        }else {
            //studentDao.save(sid,spasw,sdept,sname);
            request.getRequestDispatcher("/re_success.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
