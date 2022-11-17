/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDao implements Dao<Product> {

    private Connection con = ConnectionOrigin.getCon();

    @Override
    public Product get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() throws SQLException {
        String sql = "SELECT * FROM Product";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Product> listProduct = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setCategoryId(rs.getInt("categoryId"));
            product.setPrice(rs.getDouble("price"));
            listProduct.add(product);
        }
        return listProduct;
    }

    @Override
    public int save(Product product) throws SQLException {
        String sql = "INSERT INTO Product (productName, categoryId, price) VALUES (?, ?, ?)";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, product.getProductName());
        stm.setInt(2, product.getCategoryId());
        stm.setDouble(3, product.getPrice());
        try {
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex) {
            con.rollback();
            return 0;
        }
    }

    @Override
    public int update(Product product) throws SQLException {
        String sql = "UPDATE Product SET productName = ?, categoryId = ?, price = ? where productId = ?";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, product.getProductName());
        stm.setInt(2, product.getCategoryId());
        stm.setDouble(3, product.getPrice());
        stm.setInt(4, product.getProductId());
        try {
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex) {
            con.rollback();
            return 0;
        }
    }

    @Override
    public int delete(Product product) throws SQLException {
        String sql = "DELETE Product where productId = ?";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, product.getProductId());
        try {
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex) {
            con.rollback();
            return 0;
        }
    }

    public List getAllProductByName(String productName) throws SQLException {
        String sql = "SELECT * FROM Product WHERE productName LIKE '%" + productName + "%'";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Product> listProduct = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setCategoryId(rs.getInt("categoryId"));
            product.setPrice(rs.getDouble("price"));
            listProduct.add(product);
        }
        return listProduct;
    }
    
}
