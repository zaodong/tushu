package com.rx.tushu.dao;

import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Categoryinfo;
import com.rx.tushu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Categoryinfo> selectCategoryAll() {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();
            ArrayList<Categoryinfo> categoryinfos = new ArrayList<>();
            String sql="select * from categoryinfo";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Categoryinfo categoryinfo = new Categoryinfo();
                categoryinfo.setCID(resultSet.getInt("CID"));
               categoryinfo.setCName(resultSet.getString("CName"));
               categoryinfos.add(categoryinfo);
            }
            return categoryinfos;
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

    public boolean addCategory(String cName) {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="select * from categoryinfo where CName=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()){
                String sql2="insert into categoryinfo (CName) values (?)";
                preparedStatement= connection.prepareStatement(sql2);
                preparedStatement.setString(1,cName);
                preparedStatement.executeUpdate();
                return true;
            }
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
        return false;
    }

    public void deleteCategory(Integer integer) {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="delete  from bookinfo where BCategoryID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,integer);
            int i = preparedStatement.executeUpdate();
                String sql2="delete from categoryinfo where CID=?";
                preparedStatement= connection.prepareStatement(sql2);
                preparedStatement.setInt(1,integer);
                preparedStatement.executeUpdate();
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
    }
}
