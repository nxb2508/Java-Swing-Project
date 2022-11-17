package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Time;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Bill {

    private String billId, customerName, mobileNumber, orderDate, orderTime;
    private double total;

    public Bill(String billId, String customerName, String mobileNumber, double total) {
        this.billId = billId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.orderDate = null;
        this.orderTime = null;
        this.total = total;
    }

    public Bill(String billId, String customerName, String mobileNumber, String orderDate, String orderTime, double total) {
        this.billId = billId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.total = total;
    }

    
//        public Bill(String billId, String customerName, String mobileNumber, double total) {
//        this.billId = billId;
//        this.customerName = customerName;
//        this.mobileNumber = mobileNumber;
//        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        this.orderTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//        this.dateTime = LocalDateTime.parse(orderDate + " " + orderTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        this.total = total;
//    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
 
    
    public String toString(){
        return billId + " " + customerName + " " + mobileNumber + " " + orderDate + " " + orderTime + " " + total;
    }
    
}
