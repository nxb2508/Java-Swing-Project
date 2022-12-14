/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CoffeeWithMe extends javax.swing.JFrame {
    private String usernameLogin = null;
    
    /**
     * Creates new form CoffeeWithMe
     */
    public CoffeeWithMe() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CoffeeWithMe(String username){
        usernameLogin = username;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChangePassword = new javax.swing.JButton();
        btnManageProduct = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        btnManageBill = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnChangePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 332, 250, 250));

        btnManageProduct.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnManageProduct.setText("Manage Product");
        btnManageProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 332, 250, 250));

        btnPlaceOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlaceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 332, 250, 250));

        btnManageBill.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnManageBill.setText("Manage Bill");
        btnManageBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 332, 250, 250));

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogOut.setText("Log  Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut);

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1397, 12, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int confirmLogOut = JOptionPane.showConfirmDialog(null, "Are You Sure", "Log Out", JOptionPane.YES_NO_OPTION);
        if(confirmLogOut == 0){
            setVisible(false);
            new SignIn().setVisible(true);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int confirmLogOut = JOptionPane.showConfirmDialog(null, "Are You Sure", "Exit", JOptionPane.YES_NO_OPTION);
        if(confirmLogOut == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ChangePassword(usernameLogin).setVisible(true);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnManageProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageProduct(usernameLogin).setVisible(true);
    }//GEN-LAST:event_btnManageProductActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new PlaceOrder(usernameLogin).setVisible(true);
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnManageBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBillActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageBill(usernameLogin).setVisible(true);
    }//GEN-LAST:event_btnManageBillActionPerformed

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
            java.util.logging.Logger.getLogger(CoffeeWithMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoffeeWithMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoffeeWithMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoffeeWithMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoffeeWithMe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManageBill;
    private javax.swing.JButton btnManageProduct;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
