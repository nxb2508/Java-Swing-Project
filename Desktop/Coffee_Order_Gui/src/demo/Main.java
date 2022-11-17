/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import dao.BillDao;
import java.security.Timestamp;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import model.Bill;
import model.User;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        User x = new User("1", "1", "1", "2002-12-30", "", "");
        LocalDate date = LocalDate.parse("2002-12-32");
        System.out.println(date);
//        String orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String orderTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));;
//        LocalDateTime dateTime = LocalDateTime.parse(orderDate + " " + orderTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(orderDate);
//        System.out.println(orderTime);
//        System.out.println(dateTime);
//        
//        List <Bill> bills = new BillDao().getAllBill("", "", "", "", true, false, false, false);
//        for(Bill temp : bills){
//            System.out.println(temp);
//        }
//        "SELECT * FROM Bill\n" +
//        "WHERE customerName LIKE '%?%'\n" +
//        "AND mobileNumber LIKE '%%'\n" +
//        "And orderDate LIKE '%%'\n" +
//        "AND SUBSTRING(CONVERT(Varchar(9), ordertime), 0, 9) LIKE '%03%'"
//        LocalDateTime
//        Bill bill = new Bill("1", "nxb", "012345678", 0);
//        System.out.println(bill.getOrderDay().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
//        System.out.println(new BillDao().countBill("123"));
//        System.out.println(Double.parseDouble("a"));
//        int amount = jtbBill.getRowCount();
//        if (amount != 0) {
//            try {
//                String mobileNumber = jtfMobileNumber.getText();
//                int cnt = new BillDao().countBill(mobileNumber) + 1;
//                String id = mobileNumber + "_" + cnt;
//                String customerName = jtfCustomerName.getText();
//                Bill bill = new Bill(id, customerName, mobileNumber, total);
//                int result = new BillDao().save(bill);
//                if (result == 1) {
//                    JOptionPane.showMessageDialog(null, "Tao Bill Thanh Cong!");
//                    String path = "C:\\Users\\ADMIN\\Desktop\\SQL BTL JAVA\\" + id + ".pdf";
//                    Document document = new Document();
//                    try {
//                        PdfWriter.getInstance(document, new FileOutputStream(path));
//                        document.open();
//                        Paragraph para = new Paragraph("----------------------------------------------------------- Receipt  -----------------------------------------------------------\n");
//                        para.add("Id: " + id + "\n");
//                        para.add("Customer Name: " + customerName + "\n");
//                        para.add("Mobile Number: " + mobileNumber + "\n");
//                        para.add("Time: " + bill.getOrderDay().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")) + "\n");
//                        para.add("----------------------------------------------------------------------------------------------------------------------------------\n\n");
//                        document.add(para);
//                        PdfPTable ptb = new PdfPTable(4);
//                        ptb.addCell("Name");
//                        ptb.addCell("Price");
//                        ptb.addCell("Quantity");
//                        ptb.addCell("Total");
//                        DefaultTableModel billModel = (DefaultTableModel) jtbBill.getModel();
//                        for (int i = 0; i < jtbBill.getRowCount(); i++) {
//                            ptb.addCell((String) billModel.getValueAt(i, 2));
//                            ptb.addCell((String) billModel.getValueAt(i, 0));
//                            ptb.addCell((String) billModel.getValueAt(i, 1));
//                            ptb.addCell((String) billModel.getValueAt(i, 3));
//                        }
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("Total");
//                        ptb.addCell("" + total);
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("Cash");
//                        ptb.addCell(jtfCash.getText());
//                        ptb.addCell("");
//                        ptb.addCell("");
//                        ptb.addCell("Change");
//                        ptb.addCell("" + (Double.parseDouble(jtfCash.getText()) - total));
//                        document.add(ptb);
//                        Paragraph endBill = new Paragraph("\n\n----------------------------------------------------------------------------------------------------------------------------------\n\n");
//                        document.add(endBill);
//
//                    } catch (DocumentException | FileNotFoundException ex) {
//                        JOptionPane.showMessageDialog(null, "Tao File Khong Thanh Cong!!!");
//                        Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    document.close();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Tao Bill Thanh Cong!");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Chua Co Mat Hang!!!");
////        }
//        List<Bill> bills = new BillDao().getAllBill("", "", "01");
//        for(Bill temp : bills){
//            System.out.println(temp.getBillId());
//            System.out.println(temp.getCustomerName());
//            System.out.println(temp.getMobileNumber());
//            System.out.println(temp.getTotal());
//            System.out.println(temp.getOrderDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        }

    }
        
}
