package cn.edu.anna.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "MLogoutServlet",urlPatterns = {"/m/m_logout.do"})
public class MLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cur_user");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if ("autoLogin".equals(c.getName())) {
                    //设置cookie存活时间为0
                    c.setMaxAge(0);
                    //将cookie响应到前台
                    response.addCookie(c);
                    break;
                }
            }
        }
        // 重定向到首页
        response.sendRedirect("../m_sign.jsp");
    }
}
