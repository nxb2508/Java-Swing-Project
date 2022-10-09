package dao;

import java.sql.*;

public class ConnectionOrigin {
    public static Connection getCon(){
        try{
            String url = "jdbc:sqlserver://GANGSTER\\SQLEXPRESS;databaseName=CoffeeSystem;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "gangster2508";
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException sqlEx){
            return null;
        }
    }
    
}
