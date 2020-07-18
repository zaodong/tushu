package com.rx.tushu.dao;

import com.rx.tushu.model.Admininfo;
import com.rx.tushu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public Admininfo selectOne(String aLoginID, String aLoginPSW) {
        Connection connection=null;
        try {
             connection = JdbcUtil.getConnection();
            Admininfo admininfo=null;
            String sql="select * from admininfo where ALoginID=? and ALoginPSW=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,aLoginID);
            preparedStatement.setString(2,aLoginPSW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 admininfo = new Admininfo();
                admininfo.setAID(resultSet.getInt("AID"));
                admininfo.setALoginID(resultSet.getString("ALoginID"));
                admininfo.setALoginPSW(resultSet.getString("ALoginPSW"));
                admininfo.setAName(resultSet.getString("AName"));
            }
            return admininfo;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtil.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
      return null;
    }
}
