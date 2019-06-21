package cn.edu.anna.manager;

import cn.edu.anna.BaseDao;
import cn.edu.anna.stu.Course;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class CollegeDao extends BaseDao {
    public void add(String college,String intro){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "insert into Dept(Dept,Dintro) values(?,?)";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1,college);
            pstmt.setString(2,intro);
            pstmt.executeUpdate();
            dbconn.close();

        } catch (SQLException ne) {
        }
    }

    public void delete(String did){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="delete from Dept where DID=?";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,did);
            int count=0;
            System.out.println(count);
            count=pst.executeUpdate();
            System.out.println(count);
            dbconn.close();
        }catch (SQLException e){

        }
    }

    public void update(String did,String college,String intro){
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="UPDATE Dept SET Dept= ? , Dintro=? WHERE DID = ? ";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            pst.setString(1,college);
            System.out.println(college);
            pst.setString(2,intro);
            System.out.println(intro);
            pst.setString(3,did);
            System.out.println(did);
            int count=0;
            System.out.println(count);
            count=pst.executeUpdate();
            System.out.println(count);
            dbconn.close();
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public ArrayList<College> list(){
        ArrayList<College> colleges=new ArrayList<>();
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select * from Dept";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            ResultSet resultSet=pst.executeQuery();
            while (resultSet.next()){
                College college=new College();
                college.setCollege(resultSet.getString("Dept"));
                college.setDid(resultSet.getString("DID"));
                college.setDintro(resultSet.getString("Dintro"));
                colleges.add(college);
            }
            resultSet.close();
            dbconn.close();
        }catch (SQLException e){

        }
        return colleges;
    }


}
