package com.rx.tushu.dao;

import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Bookinfo;
import com.rx.tushu.model.Categoryinfo;
import com.rx.tushu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public List<Bookinfo> selectProductAll() {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();

            ArrayList<Bookinfo> bookinfos = new ArrayList<>();
            String sql="SELECT bookinfo.*,categoryinfo.* FROM bookinfo LEFT JOIN categoryinfo on bookinfo.BCategoryID=categoryinfo.CID";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Bookinfo bookinfo = new Bookinfo();
                bookinfo.setBID(resultSet.getInt("BID"));
                bookinfo.setBTitle(resultSet.getString("BTitle"));
                bookinfo.setBAuthor(resultSet.getString("BAuthor"));
                bookinfo.setBPrice(resultSet.getInt("BPrice"));
                bookinfo.setBCategoryID(resultSet.getInt("BCategoryID"));
                bookinfo.setBPublisher(resultSet.getString("BPublisher"));
                bookinfo.setBPhoto(resultSet.getString("BPhoto"));
                Categoryinfo categoryinfo = new Categoryinfo();
                categoryinfo.setCID(resultSet.getInt("CID"));
                categoryinfo.setCName(resultSet.getString("CName"));
                bookinfo.setCategoryinfo(categoryinfo);
                bookinfos.add(bookinfo);
            }
            return bookinfos;
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

    public void addProduct(String bTitle, String bAuthor, int bPrice, Integer bCategoryID, String bPublisher, String bPhoto) {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();

            String sql="insert into bookinfo (BTitle,BAuthor,BPrice,BCategoryID,BPublisher,BPhoto) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bTitle);
            preparedStatement.setString(2,bAuthor);
            preparedStatement.setInt(3,bPrice);
            preparedStatement.setInt(4,bCategoryID);
            preparedStatement.setString(5,bPublisher);
            preparedStatement.setString(6,bPhoto);
            int i = preparedStatement.executeUpdate();

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

    public void deleteProduct(Integer integer) {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="delete  from bookinfo where BID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

    public Bookinfo selectProductOne(Integer bid) {
        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();
            String sql="SELECT bookinfo.*,categoryinfo.* FROM bookinfo LEFT JOIN categoryinfo on bookinfo.BCategoryID=categoryinfo.CID where BID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Bookinfo bookinfo = new Bookinfo();
                bookinfo.setBID(resultSet.getInt("BID"));
                bookinfo.setBTitle(resultSet.getString("BTitle"));
                bookinfo.setBAuthor(resultSet.getString("BAuthor"));
                bookinfo.setBPrice(resultSet.getInt("BPrice"));
                bookinfo.setBCategoryID(resultSet.getInt("BCategoryID"));
                bookinfo.setBPublisher(resultSet.getString("BPublisher"));
                bookinfo.setBPhoto(resultSet.getString("BPhoto"));
                Categoryinfo categoryinfo = new Categoryinfo();
                categoryinfo.setCID(resultSet.getInt("CID"));
                categoryinfo.setCName(resultSet.getString("CName"));
                bookinfo.setCategoryinfo(categoryinfo);
                return bookinfo;
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
        return null;
    }

    public void updateProduct(Integer bid, String bTitle, String bAuthor, Integer bPrice, Integer bCategoryID, String bPublisher, String url) {

        Connection connection=null;
        try {
            connection = JdbcUtil.getConnection();

            String sql="update bookinfo set  BTitle=?,BAuthor=?,BPrice=?,BCategoryID=?,BPublisher=?,BPhoto=? where BID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bTitle);
            preparedStatement.setString(2,bAuthor);
            preparedStatement.setInt(3,bPrice);
            preparedStatement.setInt(4,bCategoryID);
            preparedStatement.setString(5,bPublisher);

            preparedStatement.setString(6,url);
            preparedStatement.setInt(7,bid);
            int i = preparedStatement.executeUpdate();

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
