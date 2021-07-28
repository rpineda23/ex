package com.ex.db;

import java.sql.*;  

public class LoginDAO {  
public boolean validate(int employeeId,String password){  
	PreparedStatement ps = null;
    ResultSet rs = null;
    boolean status=false;  
    
    try(Connection connection = ConnectionDB.getConnection()) {
    	String sql =  "select * from employee where EmployeeId=? and Password=?"; 
        ps = connection.prepareStatement(sql);
        ps.setInt(1,employeeId);  
        ps.setString(2,password);  
          
        rs = ps.executeQuery();  
        status=rs.next(); 
        
    } catch(SQLException e) {
        e.printStackTrace();
    } finally {
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
return status;  
}  
}   