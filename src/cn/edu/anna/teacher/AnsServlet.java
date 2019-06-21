package cn.edu.anna.teacher;

import cn.edu.anna.manager.Teacher;
import cn.edu.anna.stu.Message;
import cn.edu.anna.stu.MessageDao;
import cn.edu.anna.stu.Student;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@MultipartConfig(maxFileSize = 5*1024*1024)
@WebServlet(name = "AnsServlet",urlPatterns = {"/teacher/answer.do"})
public class AnsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        //        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        Teacher teacher=(Teacher) request.getSession().getAttribute("cur_teacher");
//        String tid=teacher.getTid();
//        String tname=teacher.getTname();
//        String ans=request.getParameter("ans");
//        String mid=request.getParameter("mid");
//        String cname=request.getParameter("cname");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String atime = dateFormat.format( new Date() );
//        MessageDao messageDao=new MessageDao();
//        messageDao.addAns(ans,tid,tname,atime,mid);
//        ArrayList<Message> messageArrayList=messageDao.list();
//        request.getSession().removeAttribute("message_list");
//        request.getSession().setAttribute("message_list",messageArrayList);
//        if (cname!=null){
//            request.getRequestDispatcher("all_message.jsp?cname="+cname).forward(request,response);
//        }else {
//            request.getRequestDispatcher("home.jsp").forward(request,response);
//        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname=null;
        List<String> pList = new ArrayList<>();
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
//        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        String savePath=getServletContext().getRealPath("upload/");
        System.out.println(savePath);
        File file = new File(savePath);
        System.out.println(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        System.out.println(savePath);
        //消息提示
        String message2 = "DDDDD";
        try{
            System.out.println(savePath);
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据.
                return;
            }
            System.out.println("ddddd");
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);

            System.out.println(list.size());
            for(Iterator iter = list.iterator(); iter.hasNext();){
                FileItem item = (FileItem) iter.next();
                //如果fileitem中封装的是普通输入项的数据
                System.out.println("dddddddd");
                if(!item.isFormField()){//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    fname=filename;
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath+ filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message2 = "图片上传成功！";
                    System.out.println("dddddddd");
                }else {
                    String value = item.getString("UTF-8");
                    pList.add(value);
                }

            }
        }catch (Exception e) {
            message2= "图片上传失败！";
            System.out.println(e);
            e.printStackTrace();

        }
        Teacher teacher=(Teacher) request.getSession().getAttribute("cur_teacher");
        String tid=teacher.getTid();
        String tname=teacher.getTname();
        String ans=pList.get(0);
        String mid=pList.get(1);
        String cname=pList.get(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String atime = dateFormat.format( new Date() );
        MessageDao messageDao=new MessageDao();
        messageDao.addAns(ans,tid,tname,atime,mid,fname);
        ArrayList<Message> messageArrayList=messageDao.list();
        request.getSession().removeAttribute("message_list");
        request.getSession().setAttribute("message_list",messageArrayList);
        request.setAttribute("cname",cname);
        request.getRequestDispatcher("all_message.jsp?").forward(request,response);



    }
}
