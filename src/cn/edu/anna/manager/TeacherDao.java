package cn.edu.anna.manager;

import cn.edu.anna.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao extends BaseDao {
    public void add(String tid,String tname,String ttitle,String tintro,String dept){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into Teacher(TID,Tpasw,Tname,Ttitle,Tintro,Tdept) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,tid);
            pstmt.setString(2,tid);
            pstmt.setString(3,tname);
            pstmt.setString(4,ttitle);
            pstmt.setString(5,tintro);
            pstmt.setString(6,dept);
            pstmt.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
        }
    }

    public void delete(String tid){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="delete from Teacher where TID=?";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,tid);
            pst.executeUpdate();
            dbconn.close();
        }catch (SQLException e){

        }
    }

    public void update(String tid,String tname,String ttitle,String tintro,String dept){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="UPDATE Teacher SET Tname= ? , Ttitle=? , Tintro=? , Tdept=? WHERE TID = ? ";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,tname);
            pst.setString(2,ttitle);
            pst.setString(3,tintro);
            pst.setString(4,dept);
            pst.setString(5,tid);
            pst.executeUpdate();
            dbconn.close();
        }catch (SQLException e){

        }
    }

    public ArrayList<Teacher> list(){
        ArrayList<Teacher> teachers=new ArrayList<>();
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select * from Teacher";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            ResultSet resultSet=pst.executeQuery();
            while (resultSet.next()){
                Teacher teacher=new Teacher();
                teacher.setTid(resultSet.getString("TID"));
                teacher.setTname(resultSet.getString("Tname"));
                teacher.setTintro(resultSet.getString("Tintro"));
                teacher.setTtitle(resultSet.getString("Ttitle"));
                teacher.setTdept(resultSet.getString("Tdept"));
                teachers.add(teacher);
            }
            resultSet.close();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return teachers;
    }

    public int getTotal() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM Teacher";
        try {
            Connection dbconn= dataSource.getConnection();
            PreparedStatement ps = dbconn.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            resultSet.next();
            total=resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }


    public ArrayList<Teacher> list1() {
        return list1(0, Short.MAX_VALUE);
    }

    public ArrayList<Teacher> list1(int start, int count) {

        ArrayList<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM Teacher ORDER BY TID desc limit ?,?";

        try {
            Connection dbconn= dataSource.getConnection();
            PreparedStatement ps = dbconn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                Teacher teacher=new Teacher();
                teacher.setTid(resultSet.getString("TID"));
                teacher.setTname(resultSet.getString("Tname"));
                teacher.setTintro(resultSet.getString("Tintro"));
                teacher.setTtitle(resultSet.getString("Ttitle"));
                teacher.setTdept(resultSet.getString("Tdept"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }



    public int check(String tid,String tpasw){
        int flag=0;
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select * from Teacher";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            ResultSet resultSet=pst.executeQuery();
            System.out.println(tid);
            System.out.println(tpasw);
            while (resultSet.next()){
                String id=resultSet.getString("TID");
                String pass=resultSet.getString("Tpasw");
                if (id.equals(tid)&&pass.equals(tpasw)){
                    flag=1;
                    break;
                }
            }
            System.out.println(flag);
            resultSet.close();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return flag;
    }

    public Teacher getTeacherMessage(String tid){
        Teacher teacher=new Teacher();
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select * from Teacher";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            ResultSet resultSet=pst.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("TID");
                if (id.equals(tid)){
                    teacher.setTid(resultSet.getString("TID"));
                    teacher.setTname(resultSet.getString("Tname"));
                    teacher.setTintro(resultSet.getString("Tintro"));
                    teacher.setTtitle(resultSet.getString("Ttitle"));
                    teacher.setTdept(resultSet.getString("Tdept"));
                    break;
                }
            }
            resultSet.close();
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }
        return teacher;
    }

    public void changePasw(String tid,String tpasw){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Teacher SET Tpasw= ?  WHERE (TID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,tpasw);
            pst.setString(2,tid);
            pst.executeUpdate();

            dbconn.close();

        } catch (SQLException ne) {
        }
    }
}
