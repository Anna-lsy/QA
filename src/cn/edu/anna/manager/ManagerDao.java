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

public class ManagerDao extends BaseDao {

    public int check(String mid,String mpasw){
        int flag=0;
        try {
            Connection dbconn= dataSource.getConnection();
            String sql="select * from Manager";
            PreparedStatement pst=dbconn.prepareStatement(sql);
            ResultSet resultSet=pst.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("MID");
                String pasw=resultSet.getString("Mpasw");
                if (id.equals(mid)&&pasw.equals(mpasw)){
                    flag=1;
                }
            }
            resultSet.close();
            dbconn.close();
        }catch (SQLException e){

        }
        return flag;
    }

    public void changePasw(String mid,String mpasw){
        try {
            Connection dbconn = dataSource.getConnection();
            String sql = "UPDATE Manager SET Mpasw= ?  WHERE (MID = ?)  ";
            PreparedStatement pst = dbconn.prepareStatement(sql);
            pst.setString(1,mpasw);
            pst.setString(2,mid);
            pst.executeUpdate();

            dbconn.close();

        } catch (SQLException ne) {
        }
    }
}
