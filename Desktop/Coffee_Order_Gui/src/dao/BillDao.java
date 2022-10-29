/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author ADMIN
 */
public class BillDao implements Dao<Bill>{

    @Override
    public Bill get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bill> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(Bill bill) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        con.setAutoCommit(false);
        String sql = "INSERT INTO Bill VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bill.getId());
        stm.setString(2, bill.getCustomerName());
        stm.setString(3, bill.getMobileNumber());
        stm.setString(4, bill.getOrderDay().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
        stm.setDouble(5, bill.getGrandTotal());
        try{
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex){
            con.rollback();
            JOptionPane.showMessageDialog(null, "Xay Ra Loi!");
            return 0;
        }
    }

    @Override
    public int insert(Bill t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Bill t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Bill t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int countBill(Bill bill) throws SQLException{
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT COUNT(*) FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bill.getMobileNumber());
        ResultSet rs = stm.executeQuery();
        int cnt = 0;
        if(rs.next()) cnt = Integer.parseInt(rs.getString(1));
        return cnt;
    }
    
    public int countBill(String mobileNumber) throws SQLException{
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT COUNT(*) FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, mobileNumber);
        ResultSet rs = stm.executeQuery();
        int cnt = 0;
        if(rs.next()) cnt = Integer.parseInt(rs.getString(1));
        return cnt;
    }
    
    public String findNameByMobileNumber(String mobileNumber) throws SQLException{
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT TOP(1) name FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, mobileNumber);
        ResultSet rs = stm.executeQuery();
        String name = "";
        if(rs.next()){
            name += rs.getString(1);
        }
        return name;
    }
    
}
