/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System;

import dao.UserDao;
import java.sql.*;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.User;

/**
 *
 * @author ADMIN
 */
public class SignIn extends javax.swing.JFrame {

    private String pinRegex = "nhom9btl";

    /**
     * Creates new form SignIn
     */
    public SignIn() {
        initComponents();
        setLocationRelativeTo(null);
        btnSignIn.setEnabled(false);
        btnClear.setEnabled(false);
    }

    public void clear() {
        jtfUsername.setText("");
        jpwfPassword.setText("");
        jpwfPin.setText("");
        btnSignIn.setEnabled(false);
        btnClear.setEnabled(false);
    }

    public void showBtnSignIn() {
        String username = jtfUsername.getText();
        String password = String.valueOf(jpwfPassword.getPassword());
        String pin = String.valueOf(jpwfPin.getPassword());
        if (!username.equals("") && !password.equals("") && !pin.equals("")) {
            btnSignIn.setEnabled(true);
        } else {
            btnSignIn.setEnabled(false);
        }
    }

    public void showBtnClear() {
        String username = jtfUsername.getText();
        String password = String.valueOf(jpwfPassword.getPassword());
        String pin = String.valueOf(jpwfPin.getPassword());
        if (!username.equals("") || !password.equals("") || !pin.equals("")) {
            btnClear.setEnabled(true);
        } else {
            btnClear.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jpwfPassword = new javax.swing.JPasswordField();
        jpwfPin = new javax.swing.JPasswordField();
        btnSignIn = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnForgotPassword = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 108, 42));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 108, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("PIN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 108, -1));

        jtfUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUsernameKeyReleased(evt);
            }
        });
        getContentPane().add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 607, 42));

        jpwfPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpwfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpwfPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jpwfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 607, 44));

        jpwfPin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpwfPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpwfPinKeyReleased(evt);
            }
        });
        getContentPane().add(jpwfPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 607, 44));

        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 155, 46));

        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 150, 46));

        btnForgotPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnForgotPassword.setText("Forgotten password?");
        btnForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 680, 607, 43));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 590, 150, 46));

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 41));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Coffee With Me");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1600, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Log In");
        jPanel3.add(jLabel5);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 111, 1600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed

        // TODO add your handling code here:
        String username = jtfUsername.getText();
        String password = String.valueOf(jpwfPassword.getPassword());
        String pin = String.valueOf(jpwfPin.getPassword());
        try {
            User user = new UserDao().findByUsername(username);
            if (user != null) {
                if (password.equals(user.getPassword()) && pin.equals(pinRegex)) {
                    setVisible(false);
                    new CoffeeWithMe(username).setVisible(true);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Tai Khoan Hoac Mat Khau Khong Dung!");
                    clear();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Tai Khoan Hoac Mat Khau Khong Dung!");
            clear();
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Xay Ra Loi Dinh Dang Ngay Thang!");
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new SignUp().setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPasswordActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new RecoveryAccount().setVisible(true);
    }//GEN-LAST:event_btnForgotPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int confirmExit = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit!!!", JOptionPane.YES_NO_OPTION);
        if (confirmExit == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jtfUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsernameKeyReleased
        // TODO add your handling code here:
        showBtnSignIn();
        showBtnClear();
    }//GEN-LAST:event_jtfUsernameKeyReleased

    private void jpwfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpwfPasswordKeyReleased
        // TODO add your handling code here:
        showBtnSignIn();
        showBtnClear();
    }//GEN-LAST:event_jpwfPasswordKeyReleased

    private void jpwfPinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpwfPinKeyReleased
        // TODO add your handling code here:
        showBtnSignIn();
        showBtnClear();
    }//GEN-LAST:event_jpwfPinKeyReleased

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnForgotPassword;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jpwfPassword;
    private javax.swing.JPasswordField jpwfPin;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
