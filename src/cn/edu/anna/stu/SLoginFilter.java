package cn.edu.anna.stu;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SLoginFilter")
public class SLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getRequestURI();
        Student student=(Student)session.getAttribute("cur_user");
        if(path.indexOf("/index.jsp") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (student == null || "".equals(student.getSid())) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/index.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
