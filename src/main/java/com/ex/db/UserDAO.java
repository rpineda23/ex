package com.ex.db;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ex.User;

public class UserDAO {
	User employee = new User();
  
	public void getAllEmployees() {
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try (Connection connection = ConnectionDB.getConnection()) {
	        String sql = "select * from employee";
	        
	        ps = connection.prepareStatement(sql);
	        rs = ps.executeQuery();
	        System.out.println("You are connected...");

	        while(rs.next()) {
	            employee.setEmployeeId( rs.getInt("EmployeeID"));
	            employee.setFirstName(rs.getString("FirstName"));
	            employee.setLastName( rs.getString("LastName"));
	            employee.setManagerId(rs.getInt("ManagerID"));
	            employee.setPassword(rs.getString("Password"));
	            employee.setEmployeeType(rs.getString("EmployeeType"));
	            
	            employee.toString(employee.getEmployeeId(),  employee.getFirstName() ,employee.getLastName() , employee.getManagerId(), employee.getPassword() , employee.getEmployeeType()); 
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

    public User getEmployeeById(int employeeId) {
        //User employee = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = ConnectionDB.getConnection()) {
            String sql = "select * from employee where EmployeeID=?";
            
            ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            rs = ps.executeQuery();
            
            if(rs.next()) {
	            employee.setEmployeeId( rs.getInt("EmployeeID"));
	            employee.setFirstName(rs.getString("FirstName"));
	            employee.setLastName( rs.getString("LastName"));
	            employee.setManagerId(rs.getInt("ManagerID"));
	            employee.setPassword(rs.getString("Password"));
	            employee.setEmployeeType(rs.getString("EmployeeType"));
	            
	            employee.toString(employee.getEmployeeId(),  employee.getFirstName() ,employee.getLastName() , employee.getManagerId(), employee.getPassword() , employee.getEmployeeType()); 
	        }

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
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return employee;
    }



    public void updateEmployeePassword(int employeeId, String password) throws IOException {
        CallableStatement cs = null;

        try(Connection connection = ConnectionDB.getConnection()) {
            String sql = "update employee set password=? where EmployeeId=?";
            cs = connection.prepareCall(sql);
            cs.setString(1, password);
            cs.setInt(2, employeeId);

            cs.execute();
            cs.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if(cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}