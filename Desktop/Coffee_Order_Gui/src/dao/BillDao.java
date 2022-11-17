/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author ADMIN
 */
public class BillDao implements Dao<Bill> {

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
        String sql = "INSERT INTO Bill VALUES(?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bill.getBillId());
        stm.setString(2, bill.getCustomerName());
        stm.setString(3, bill.getMobileNumber());
        stm.setDouble(4, bill.getTotal());
        try {
            int result = stm.executeUpdate();
            con.commit();
            return result;
        } catch (SQLException ex) {
            con.rollback();
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Bill t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Bill t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int countBill(Bill bill) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT COUNT(*) FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, bill.getMobileNumber());
        ResultSet rs = stm.executeQuery();
        int cnt = 0;
        if (rs.next()) {
            cnt = Integer.parseInt(rs.getString(1));
        }
        return cnt;
    }

    public int countBill(String mobileNumber) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT COUNT(*) FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, mobileNumber);
        ResultSet rs = stm.executeQuery();
        int cnt = 0;
        if (rs.next()) {
            cnt = Integer.parseInt(rs.getString(1));
        }
        return cnt;
    }

    public String findNameByMobileNumber(String mobileNumber) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT TOP(1) customerName FROM Bill WHERE mobileNumber = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, mobileNumber);
        ResultSet rs = stm.executeQuery();
        String name = null;
        if (rs.next()) {
            name = rs.getString("customerName");
        }
        return name;
    }

    public String getOrderDate(String billId) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT orderDate FROM Bill WHERE billId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, billId);
        ResultSet rs = stm.executeQuery();
        String orderDate = null;
        if (rs.next()) {
            orderDate = rs.getString("orderDate");
        }
        return orderDate;
    }

    public String getOrderTime(String billId) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT orderTime FROM Bill WHERE billId = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, billId);
        ResultSet rs = stm.executeQuery();
        String orderTime = null;
        if (rs.next()) {
            orderTime = rs.getString("orderTime");
        }
        if (orderTime != null) {
            return orderTime.substring(0, 8);
        } else {
            return null;
        }
    }

    public List<Bill> getAllBill(String cusName, String moNumber, String odDate, String odTime) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT * FROM Bill\n";
        sql += "WHERE customerName LIKE '%" + cusName + "%'\n";
        sql += "AND mobileNumber LIKE '%" + moNumber + "%'\n";
        sql += "AND orderDate LIKE '%" + odDate + "%'\n";
        sql += "AND SUBSTRING(CONVERT(Varchar(9), ordertime), 0, 9) LIKE '%" + odTime + "%'";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Bill> bills = new ArrayList<>();
        while (rs.next()) {
            String billId = rs.getString("billId");
            String customerName = rs.getString("customerName");
            String mobileNumber = rs.getString("mobileNumber");
            String orderDate = rs.getDate("orderDate").toString();
            String orderTime = rs.getTime("orderTime").toString();
            double total = rs.getDouble("total");
            Bill temp = new Bill(billId, customerName, mobileNumber, orderDate, orderTime, total);
            bills.add(temp);
        }
        return bills;
    }

    public List<Bill> getAllBill(String cusName, String moNumber, String odDate, String odTime, boolean dateTimeAsc, boolean dateTimeDesc, boolean totalAsc, boolean totalDesc) throws SQLException {
        Connection con = ConnectionOrigin.getCon();
        String sql = "SELECT * FROM Bill\n";
        sql += "WHERE customerName LIKE '%" + cusName + "%'\n";
        sql += "AND mobileNumber LIKE '%" + moNumber + "%'\n";
        sql += "AND orderDate LIKE '%" + odDate + "%'\n";
        sql += "AND SUBSTRING(CONVERT(Varchar(9), ordertime), 0, 9) LIKE '%" + odTime + "%'\n";
        if(dateTimeAsc && !dateTimeDesc && !totalAsc && !totalDesc){
            sql += "ORDER BY orderDate ASC, orderTime ASC";
        } else if (dateTimeAsc && !dateTimeDesc && totalAsc && !totalDesc){
            sql += "ORDER BY orderDate ASC, orderTime ASC, total ASC";
        } else if(dateTimeAsc && !dateTimeDesc && totalDesc && !totalAsc){
            sql += "ORDER BY orderDate ASC, orderTime ASC, total DESC";
        } else if(dateTimeDesc && !dateTimeAsc && !totalAsc && !totalDesc){
            sql += "ORDER BY orderDate DESC, orderTime DESC";
        } else if(dateTimeDesc && !dateTimeAsc && totalAsc && !totalDesc){
            sql += "ORDER BY orderDate DESC, orderTime DESC, total ASC";
        } else if(dateTimeDesc && !dateTimeAsc && totalDesc && !totalAsc){
            sql += "ORDER BY orderDate DESC, orderTime DESC, total DESC";
        } else if(totalAsc && !totalDesc && !dateTimeAsc && !dateTimeDesc){
            sql += "ORDER BY total ASC";
        } else if(totalDesc  && !totalAsc && !dateTimeAsc && !dateTimeDesc){
            sql += "ORDER BY total DESC";
        }
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Bill> bills = new ArrayList<>();
        while (rs.next()) {
            String billId = rs.getString("billId");
            String customerName = rs.getString("customerName");
            String mobileNumber = rs.getString("mobileNumber");
            String orderDate = rs.getDate("orderDate").toString();
            String orderTime = rs.getTime("orderTime").toString();
            double total = rs.getDouble("total");
            Bill temp = new Bill(billId, customerName, mobileNumber, orderDate, orderTime, total);
            bills.add(temp);
        }
        return bills;
    }

}
