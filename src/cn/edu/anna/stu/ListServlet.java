package cn.edu.anna.stu;

import cn.edu.anna.Page;
import cn.edu.anna.manager.Teacher;
import cn.edu.anna.manager.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListServlet",urlPatterns = {"/student/page.do"})
public class ListServlet extends HttpServlet {
    private TeacherDao teacherDao = new TeacherDao();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page_num=req.getParameter("page_num");
        // 获取分页参数
        int start = 0;
        int count = 8;

        try {
            start = Integer.parseInt(req.getParameter("page.start"));
            count = Integer.parseInt(req.getParameter("page.count"));
        } catch (Exception e) {
        }

        if (page_num!=null && page_num!=""){
            start=(Integer.parseInt(page_num)-1)*count;
        }

        Page page = new Page(start, count);

        ArrayList<Teacher> teachers = teacherDao.list1(page.getStart(), page.getCount());
        int total = teacherDao.getTotal();
        page.setTotal(total);


        req.getSession().setAttribute("teacher", teachers);
        req.getSession().setAttribute("page", page);


        req.getRequestDispatcher("/student/Teacher.jsp").forward(req, resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
