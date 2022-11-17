/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import model.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryDao implements Dao<Category>{

    private Connection con = ConnectionOrigin.getCon();
    
    @Override
    public Category get(int id) throws SQLException {
        String sql = "SELECT * FROM Category WHERE CategoryId = " + id;
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        Category category = null;
        if(rs.next()) {
            category = new Category(rs.getString("CategoryName"));
            category.setCategoryId(rs.getInt("CategoryId"));
        }
        return category;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        String sql = "SELECT * FROM Category";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Category> listCategory = new ArrayList<>();
        while (rs.next()) {
            Category temp = new Category();
            temp.setCategoryId(rs.getInt("CategoryId"));
            temp.setCategoryName(rs.getString("CategoryName"));
            listCategory.add(temp);
        }
        return listCategory;
    }

    @Override
    public int save(Category t) throws SQLException {
        con.setAutoCommit(false);
        String sql = "INSERT INTO Category (CategoryName) VALUES (?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getCategoryName());
        try{
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException sqlEx){
            return 0;
        }
    }

    @Override
    public int update(Category t) throws SQLException {
        con.setAutoCommit(false);
        String sql = "UPDATE Category SET CategoryName = ? WHERE CategoryId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getCategoryName());
        stm.setInt(2, t.getCategoryId());
        try{
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException sqlEx){
            con.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Category t) throws SQLException {
        con.setAutoCommit(false);
        String sql = "DELETE Category WHERE CategoryId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, t.getCategoryId());
        try{
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException sqlEx){
            con.rollback();
            return 0;
        }
    }
    
    
    public List<Category> getAllByCategoryName(String categoryName) throws SQLException {
        String sql = "SELECT * FROM Category WHERE CategoryName LIKE '%" + categoryName + "%'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Category> listCategory = new ArrayList<>();
        while (rs.next()) {
            Category temp = new Category();
            temp.setCategoryId(rs.getInt("CategoryId"));
            temp.setCategoryName(rs.getString("CategoryName"));
            listCategory.add(temp);
        }
        return listCategory;
    }
}
