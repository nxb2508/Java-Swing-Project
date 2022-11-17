/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDao {

    public List getAll() throws SQLException, DateTimeParseException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT * FROM Account";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<User> listUser = new ArrayList<>();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullName");
            String dateOfBirth = rs.getDate("dateofbirth").toString();
            String address = rs.getString("address");
            String phoneNumber = rs.getString("phonenumber");
            User temp = new User(username, password, fullName, dateOfBirth, address, phoneNumber);
            listUser.add(temp);
        }
        return listUser;
    }

    public int save(User t) throws SQLException, ParseException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "INSERT INTO Account(username, password, fullname, dateofbirth, address, phonenumber) VALUES (?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getUsername());
        stm.setString(2, t.getPassword());
        stm.setString(3, t.getFullName());
        stm.setDate(4, new java.sql.Date(t.getDateSql().getTime()));
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

    public int update(User t) throws SQLException, ParseException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "UPDATE Account SET password = ?, fullname = ?, dateofbirth = ?, address = ?, phonenumber = ? WHERE username = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, t.getPassword());
        stm.setString(2, t.getFullName());
        stm.setDate(3, new java.sql.Date(t.getDateSql().getTime()));
        stm.setString(4, t.getAddress());
        stm.setString(5, t.getPhoneNumber());
        stm.setString(6, t.getUsername());
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

    public User findByUsername(String username) throws DateTimeParseException {
        try {
            Connection con = ConnectionOrigin.getCon();
            String sql = "SELECT * FROM Account WHERE username = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                String fullName = rs.getString("fullName");
                String dateOfBirth = rs.getDate("dateofbirth").toString();
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
