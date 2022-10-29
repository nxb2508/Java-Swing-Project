/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System;

import dao.ProductDao;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.table.*;
import model.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.BillDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author ADMIN
 */
public class PlaceOrder extends javax.swing.JFrame {
    private String usernameLogin = null;
    private String phoneNumberRegex = "0([1-9]){9}";
    
    private double grandTotal;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
        setLocationRelativeTo(null);
        btnAddToCart.setEnabled(false);
        btnGenerateBill.setEnabled(false);
        grandTotal = 0;
    }
    
    public PlaceOrder(String username) {
        initComponents();
        usernameLogin = username;
        setLocationRelativeTo(null);
        btnAddToCart.setEnabled(false);
        btnGenerateBill.setEnabled(false);
        grandTotal = 0;
    }

    public void showProduct() throws SQLException {
        List<Product> listProduct = new ProductDao().getAll();
        DefaultTableModel model = (DefaultTableModel) jtbProduct.getModel();
        model.setRowCount(0);
        for (Product temp : listProduct) {
            model.addRow(new Object[]{temp.getName(), temp.getPrice()});
        }
    }

    public void showBtnGenerateBill(){
        String mobileNumber = jtfMobileNumber.getText();
        if(mobileNumber.matches(phoneNumberRegex)){
            btnGenerateBill.setEnabled(true);
        } else {
            btnGenerateBill.setEnabled(false);
        }
    }
    
    public void clear() {
        jtfCustomerName.setText("");
        jtfMobileNumber.setText("");
        jtfProductName.setText("");
        jtfPrice.setText("");
        jtfTotal.setText("");
        jpnQuantity.setValue(0);
        btnAddToCart.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCustomerName = new javax.swing.JTextField();
        jtfMobileNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtfProductName = new javax.swing.JTextField();
        jtfPrice = new javax.swing.JTextField();
        jtfTotal = new javax.swing.JTextField();
        jpnQuantity = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbBill = new javax.swing.JTable();
        btnGenerateBill = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jlbGrandTotal = new javax.swing.JLabel();
        btnNewBill = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Place Order");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Customer Details:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mobile Number");

        jtfCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jtfMobileNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtfMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfMobileNumberKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Product");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Total");

        jtfProductName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jtfPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jtfTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jpnQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jpnQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jpnQuantityStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jtbProduct.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price"
            }
        ));
        jtbProduct.setRowHeight(40);
        jtbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProduct);
        if (jtbProduct.getColumnModel().getColumnCount() > 0) {
            jtbProduct.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jtbBill.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jtbBill.setRowHeight(40);
        jScrollPane2.setViewportView(jtbBill);

        btnGenerateBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jlbGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbGrandTotal.setText("Grand Total: 0");

        btnNewBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNewBill.setText("New Bill");
        btnNewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBillActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(41, 41, 41)
                .addComponent(btnExit)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(339, 339, 339)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jtfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jtfMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel5)
                        .addGap(235, 235, 235)
                        .addComponent(jLabel6)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(189, 189, 189)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(87, 87, 87)
                                .addComponent(btnAddToCart)
                                .addGap(91, 91, 91)
                                .addComponent(btnDelete))
                            .addComponent(btnNewBill)
                            .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(btnGenerateBill)))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack)
                        .addComponent(btnExit)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btnAddToCart)
                            .addComponent(btnDelete))
                        .addGap(51, 51, 51)
                        .addComponent(btnNewBill)
                        .addGap(56, 56, 56)
                        .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnGenerateBill))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String productName = jtfProductName.getText();
        String price = jtfPrice.getText();
        String quantity = String.valueOf(jpnQuantity.getValue());
        String total = jtfTotal.getText();
        DefaultTableModel model = (DefaultTableModel) jtbBill.getModel();
        model.addRow(new Object[]{productName, price, quantity, total});
        grandTotal += Double.parseDouble(total);
        jlbGrandTotal.setText("Grand Total: " + grandTotal);
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            // TODO add your handling code here:
            showProduct();
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        try {
            // TODO add your handling code here:
            String mobileNumber = jtfMobileNumber.getText();
            int cnt = new BillDao().countBill(mobileNumber) + 1;
            String id = mobileNumber + "_" + cnt;
            String customerName = jtfCustomerName.getText();
            Bill bill = new Bill(id, customerName, mobileNumber, grandTotal);
            int result = new BillDao().save(bill);
            if(result == 1){
                JOptionPane.showMessageDialog(null, "Tao Bill Thanh Cong!");
            } else {
                JOptionPane.showMessageDialog(null, "Tao Bill Thanh Cong!");
            }
//        String path = "C:\\Users\\ADMIN\\Desktop\\SQL BTL JAVA\\test.pdf";
//        Document document = new Document();
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(path));
//            document.open();
//            Paragraph para = new Paragraph("Ngo Xuan Bach");
//            document.add(para);
//            
//            JOptionPane.showMessageDialog(null, "Tao File Thanh Cong!!!");
//        } catch (DocumentException | FileNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Tao File Khong Thanh Cong!!!");
//            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        document.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id = jtbBill.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbBill.getModel();
        if (id != -1) {
            String total = (String) model.getValueAt(id, 3);
            model.removeRow(id);
            grandTotal -= Double.parseDouble(total);
            jlbGrandTotal.setText("Grand Total: " + grandTotal);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jtbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductMouseClicked
        // TODO add your handling code here:
        int index = jtbProduct.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbProduct.getModel();
        jtfProductName.setText((String) model.getValueAt(index, 0));
        jtfPrice.setText(String.valueOf(model.getValueAt(index, 1)));
        jpnQuantity.setValue(1);
        jtfTotal.setText(String.valueOf((int) jpnQuantity.getValue() * Double.parseDouble(jtfPrice.getText())));
        btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jtbProductMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpnQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jpnQuantityStateChanged
        // TODO add your handling code here:
        if (!jtfPrice.getText().equals("")) {
            jtfTotal.setText(String.valueOf((int) jpnQuantity.getValue() * Double.parseDouble(jtfPrice.getText())));
        }
    }//GEN-LAST:event_jpnQuantityStateChanged

    private void btnNewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBillActionPerformed
        // TODO add your handling code here:
        clear();
        DefaultTableModel billModel = (DefaultTableModel) jtbBill.getModel();
        billModel.setRowCount(0);
        btnAddToCart.setEnabled(false);
        grandTotal = 0;
        jlbGrandTotal.setText("Grand Total: " + grandTotal);
    }//GEN-LAST:event_btnNewBillActionPerformed

    private void jtfMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMobileNumberKeyReleased
        // TODO add your handling code here:
        showBtnGenerateBill();
        String mobileNumber = jtfMobileNumber.getText();
        if(mobileNumber.matches(phoneNumberRegex)){
            try {
                String name = new BillDao().findNameByMobileNumber(mobileNumber);
                jtfCustomerName.setText(name);
            } catch (SQLException ex) {
                Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jtfCustomerName.setText("");
        }
    }//GEN-LAST:event_jtfMobileNumberKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure?", "Back", JOptionPane.YES_NO_OPTION);
        if (confirmExit == 0) {
            setVisible(false);
            new CoffeeWithMe(usernameLogin).setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int confirmLogOut = JOptionPane.showConfirmDialog(null, "Are You Sure", "Exit", JOptionPane.YES_NO_OPTION);
        if (confirmLogOut == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnNewBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JSpinner jpnQuantity;
    private javax.swing.JTable jtbBill;
    private javax.swing.JTable jtbProduct;
    private javax.swing.JTextField jtfCustomerName;
    private javax.swing.JTextField jtfMobileNumber;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}