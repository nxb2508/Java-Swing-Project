/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDao implements Dao<User> {

    @Override
    public User get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet getAll() throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT * FROM Account";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

    @Override
    public int save(User t) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "INSERT INTO Account(username, password, fullname, dateofbirth, address, phonenumber) VALUES (?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getUsername());
        stm.setString(2, t.getPassword());
        stm.setString(3, t.getFullName());
        stm.setString(4, t.getDateOfBirth());
        stm.setString(5, t.getAddress());
        stm.setString(6, t.getPhoneNumber());
        con.setAutoCommit(false);
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
    public int insert(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(User t) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "UPDATE Account SET password = ? WHERE username = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getPassword());
        stm.setString(2, t.getUsername());
        con.setAutoCommit(false);
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
    public int delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public User findByUsername(String username){
        try{
            Connection con = ConnectionOrigin.getCon();
            String sql = "SELECT * FROM Account WHERE username = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                String password = rs.getString("password");
                String fullName = rs.getString("fullName");
                String dateOfBirth = rs.getString("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                User user = new User(username, password, fullName, dateOfBirth, address, phoneNumber);
                return user;
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
