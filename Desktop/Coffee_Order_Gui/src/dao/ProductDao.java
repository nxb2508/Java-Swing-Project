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
            Product temp = new Product();
            temp.setId(rs.getInt(1));
            temp.setName(rs.getString(2));
            temp.setType(rs.getString(3));
            temp.setPrice(rs.getDouble(4));
            listProduct.add(temp);
        }
        return listProduct;
    }

    @Override
    public int save(Product t) throws SQLException {
        String sql = "INSERT INTO Product (name, type, price) VALUES (?, ?, ?)";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getName());
        stm.setString(2, t.getType());
        stm.setDouble(3, t.getPrice());
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
    public int insert(Product t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Product t) throws SQLException {
        String sql = "UPDATE Product SET name = ?, type = ?, price = ? where id = ?";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getName());
        stm.setString(2, t.getType());
        stm.setDouble(3, t.getPrice());
        stm.setInt(4, t.getId());
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
    public int delete(Product t) throws SQLException {
        String sql = "DELETE Product where id = ?";
        Connection con = ConnectionOrigin.getCon();
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, t.getId());
        try {
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex) {
            con.rollback();
            return 0;
        }
    }

}
