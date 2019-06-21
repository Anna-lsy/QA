package cn.edu.anna.stu;
import cn.edu.anna.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDao extends BaseDao {
    public int courseCheck(String dept, String course){
        int flag=0;
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Course ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String c=rs.getString("Cname");
                String d=rs.getString("Cdept");
                if (d.equals(dept) && c.equals(course)){
                    flag=1;
                }
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
        }
        return flag;
    }
    public void update(String message,String title,String mid,String fname){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Mesage SET QU= ? , Mtitle=?,s_path=? WHERE (MID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,message);
            pst.setString(2,title);
            pst.setString(3,fname);
            pst.setString(4,mid);

            int count=0;
            count=pst.executeUpdate();
            System.out.println(count);
            dbconn.close();

        } catch (SQLException ne) {
        }

    }

    public void delete(String mid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "delete from Mesage WHERE MID = ?  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,mid);
            pst.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
        }

    }

    public void saveMessage(String sid,String mtitle,String qu,String college,String course,String time,String fanme) {
        int flag=0;
        int t=0;
        int s=0;
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into Mesage (SID,Mtitle,QU,flag,Mcollege,Mcourse,Mtime,T_hasLooked,S_hasLooked,s_path) " +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1, sid);
            pst.setString(2, mtitle);
            pst.setString(3, qu);
            pst.setInt(4,flag);
            pst.setString(5,college);
            pst.setString(6,course);
            pst.setString(7,time);
            pst.setInt(8,t);
            pst.setInt(9,s);
            pst.setString(10,fanme);
            pst.executeUpdate();
            dbconn.close();
        } catch (SQLException ne) {
        }

    }

    public Message setAll(String dept, String course){
        Message m=new Message();
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Mesage ";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                String c=rs.getString("Cname");
                String d=rs.getString("Cdept");
                if (d.equals(dept) && c.equals(course)){
                    m.setAns(rs.getString("ANS"));
                    m.setFlag(rs.getInt("flag"));
                    m.setMtitle(rs.getString("Mtitle"));
                    m.setQu(rs.getString("QU"));
                    m.setSid(rs.getString("SID"));
                    m.setTid(rs.getString("TID"));
                    m.setMcollege(rs.getString("Mcollege"));
                    m.setMcourse(rs.getString("Mcourse"));
                    m.setMtime(rs.getString("Mtime"));
                    m.setT_haslooked(rs.getInt("T_haslooked"));
                    m.setS_haslooked(rs.getInt("S_haslooked"));
                    m.setT_path(rs.getString("t_path"));
                    m.setS_path(rs.getString("s_path"));
                    break;
                }

            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
        }
        return m;
    }

    public void addAns(String ans,String tid,String tname,String atime,String mid,String fname){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Mesage SET TID= ? , Tname=?,ANS=?,Atime=?,flag=1,t_path=? WHERE (MID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,tid);
            pst.setString(2,tname);
            pst.setString(3,ans);
            pst.setString(4,atime);
            pst.setString(5,fname);
            pst.setString(6,mid);

            int count=0;
            count=pst.executeUpdate();
            System.out.println(count);
            dbconn.close();

        } catch (SQLException ne) {
        }
    }

    public void t_haslooked(String mid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Mesage SET T_haslooked=1 WHERE (MID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,mid);
            pst.executeUpdate();
            dbconn.close();

        } catch (SQLException ne) {
        }
    }

    public void s_haslooked(String mid){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Mesage SET S_haslooked=1 WHERE (MID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,mid);
            pst.executeUpdate();
            dbconn.close();

        } catch (SQLException ne) {
        }
    }

    public ArrayList<Message> list(){
        ArrayList<Message> list=new ArrayList<>();
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "select * from Mesage";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Message m=new Message();
                m.setAns(rs.getString("ANS"));
                m.setFlag(rs.getInt("flag"));
                m.setMtitle(rs.getString("Mtitle"));
                m.setQu(rs.getString("QU"));
                m.setSid(rs.getString("SID"));
                m.setTid(rs.getString("TID"));
                m.setTname(rs.getString("Tname"));
                m.setMtime(rs.getString("Mtime"));
                m.setAtime(rs.getString("Atime"));
                m.setMcourse(rs.getString("Mcourse"));
                m.setMcollege(rs.getString("Mcollege"));
                m.setMid(rs.getInt("MID"));
                m.setT_haslooked(rs.getInt("T_haslooked"));
                m.setS_haslooked(rs.getInt("S_haslooked"));
                m.setT_path(rs.getString("t_path"));
                m.setS_path(rs.getString("s_path"));
                list.add(m);
            }
            rs.close();
            dbconn.close();

        } catch (SQLException ne) {
        }
        return list;
    }

}
