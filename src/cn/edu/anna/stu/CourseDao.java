package cn.edu.anna.stu;

import cn.edu.anna.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDao extends BaseDao {

    public void update(String cid,String cname,String content,String cdept){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="UPDATE Course SET Cname= ? , Content=?, Cdept=? WHERE CID = ? ";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,cname);
            pst.setString(2,content);
            pst.setString(3,cdept);
            pst.setString(4,cid);
            pst.executeUpdate();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void add(String cid,String cname,String content,String cdept){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into Course(CID,Cname,Content,Cdept) values(?,?,?,?)";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,cid);
            pstmt.setString(2,cname);
            pstmt.setString(3,content);
            pstmt.setString(4,cdept);
            pstmt.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
            System.out.println(ne);
        }
    }

    public void add_t_course(String cid,String tid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into TC(CID,TID) values(?,?)";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,cid);
            pstmt.setString(2,tid);
            pstmt.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
            System.out.println(ne);
        }
    }

    public void delete_t_course(String cid,String tid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "delete from TC where CID=? and TID=?";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,cid);
            pstmt.setString(2,tid);
            pstmt.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
            System.out.println(ne);
        }
    }

    public void delete(String cid){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="delete from Course where CID=?";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,cid);
            pst.executeUpdate();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public String findID(String cname){
        String cid=null;
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select CID from Course where Cname=?";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,cname);
            ResultSet rs = pst.executeQuery();
            rs.next();
            cid=rs.getString("CID");
            rs.close();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return cid;
    }


    public ArrayList<Course> list(){
        ArrayList<Course> courseArrayList=new ArrayList<>();
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Course";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Course course=new Course();
                course.setCid(rs.getString("CID"));
                course.setCname(rs.getString("Cname"));
                course.setContent(rs.getString("Content"));
                course.setCdept(rs.getString("Cdept"));
                courseArrayList.add(course);
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
            System.out.println(ne);
        }
        return courseArrayList;
    }


    public ArrayList<Course> findCourselist(String tid){
        ArrayList<Course> courseArrayList=new ArrayList<>();
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select TC.CID,Tname,Cname,Content,Cdept from ACCDB.Course,ACCDB.Teacher,ACCDB.TC " +
                    "where Teacher.TID=? AND TC.TID=Teacher.TID AND TC.CID=Course.CID";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,tid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Course course=new Course();
                course.setCid(rs.getString("CID"));
                course.setTname(rs.getString("Tname"));
                course.setCname(rs.getString("Cname"));
                course.setContent(rs.getString("Content"));
                course.setCdept(rs.getString("Cdept"));
                courseArrayList.add(course);
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
            System.out.println(ne);
        }
        return courseArrayList;

    }
}
