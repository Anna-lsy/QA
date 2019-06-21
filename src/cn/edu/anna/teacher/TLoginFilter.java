package cn.edu.anna.teacher;

import cn.edu.anna.manager.Manager;
import cn.edu.anna.manager.Teacher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "TLoginFilter")
public class TLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getRequestURI();
        Teacher teacher=(Teacher) session.getAttribute("cur_teacher");
        if(path.indexOf("/index.jsp") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (teacher == null || "".equals(teacher.getTid())) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/t_sign.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
