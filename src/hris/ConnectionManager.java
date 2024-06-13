/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hris;

/**
 *
 * @author i5
 */
import java.sql.*;

public class ConnectionManager {
    protected static Connection con;

    public static Connection getConnection() {
        
        try{  
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris","root","071302Justin!"); 
                
		}catch(Exception e){
			System.out.println(e);  
		}  
        return con;
    }    
}
