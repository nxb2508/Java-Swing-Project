package dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbStatement {
    
    public static void update(String query, String msg){
        try{
            Connection con = ConnectionOrigin.getCon();
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            if(!msg.equals("")){
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Khong thuc hien duoc");
        }
    }

}
