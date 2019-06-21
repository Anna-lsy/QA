package cn.edu.anna.stu;

import cn.edu.anna.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends BaseDao {
    public int registerCheck(String sid, String spasw ,String sdept,String sname) {
        int flag=0;
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select SID from Student ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                if (rs.getString("SID").equals(sid)){
                    flag=1;
                }
            }
            System.out.println(flag);
            if (flag==0){
                String sql2="INSERT INTO Student(SID,Spasw,Sdept,Sname) VALUES (?,?,?,?);";
                PreparedStatement pst=dbconn.prepareStatement(sql2);
                pst.setString(1, sid);
                pst.setString(2, spasw);
                pst.setString(3, sdept);
                pst.setString(4, sname);
                System.out.println(sid);
                System.out.println(spasw);
                System.out.println(sdept);
                System.out.println(sname);
                pst.executeUpdate();
            }
            rs.close();
            dbconn.close();
        } catch (SQLException ne) {
        }
        return flag;
    }
    public void save(String sid, String spasw ,String sdept,String sname) {
        int flag=0;
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into Student (SID,Spasw,Sdept,Sname) values(?,?,?,?)";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1, sid);
            pst.setString(2, spasw);
            pst.setString(3, sdept);
            pst.setString(4, sname);
            pst.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
        }

    }

    public void changePasw(String pasw,String sid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Student SET Spasw= ?  WHERE (SID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,pasw);
            pst.setString(2,sid);
            pst.executeUpdate();

            dbconn.close();

        } catch (SQLException ne) {
        }
    }

    public int loginCheck(String sid, String spasw){
        int flag=0;
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Student ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String id=rs.getString("SID");
                String pass=rs.getString("Spasw");
                if (id.equals(sid) && pass.equals(spasw)){
                    flag=1;
                }
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
        }
        return flag;
    }
    public Student setAll(String sid){
        Student student=new Student();
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Student ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String id=rs.getString("SID");
                if (id.equals(sid)){
                    String spasw=rs.getString("Spasw");
                    String sdept=rs.getString("Sdept");
                    String sname=rs.getString("Sname");
                    student.setSid(id);
                    student.setSpasw(spasw);
                    student.setSdept(sdept);
                    student.setSname(sname);
                    break;
                }
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
        }
        return student;
    }
}
