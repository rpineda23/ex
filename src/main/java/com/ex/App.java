package com.ex;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ex.db.ConnectionDB;
import com.ex.db.LoginDAO;
import com.ex.db.ReimbursementDAO;
import com.ex.db.UserDAO;

//import com.mysql.jdbc.PreparedStatement;

public class App {
	public static void main(String[] args) throws IOException {
		ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
		UserDAO employeeDAO = new UserDAO();
		LoginDAO loginDAO = new LoginDAO();
		int choice=0;
		
		do {
			System.out.println("Choose an Option");
			System.out.println("1. List all employees");
			System.out.println("2. List one employee");
			System.out.println("3. Update employee information");
			System.out.println("4. List all reimbursements");
			System.out.println("5. Get reimbursement for employee");
			System.out.println("6. Update reimbursement status");
			System.out.println("7. Reimbursement Request");
			
			
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
		switch (choice) {
		case 1: {  
			employeeDAO.getAllEmployees();
		    break;
		}
		case 2: 
		{
			System.out.println("What is your employee ID?");
			int index = sc.nextInt();
			employeeDAO.getEmployeeById(index);
			break;
		}
		case 3:
		{	
			System.out.println("What is your employee ID?");
			int index = sc.nextInt();
			System.out.println("What would you like your password to be?\n");
			String password = sc.next();
			
			employeeDAO.updateEmployeePassword(index,password);
			break;
		}
		case 4: 
		{
			System.out.println("What is your manager ID?");
			int index = sc.nextInt();
			reimbursementDAO.getAllReimbursementsForManager(index);
			break;
		}
		case 5: 
		{
			System.out.println("What is your employee ID?");
			int index = sc.nextInt();
			reimbursementDAO.getAllReimbursementsForEmployee(index);
			break;
		}
		case 6:
		{
			System.out.println("What is your reimbursement ID?");
			int index = sc.nextInt();
			System.out.println("What is the status?");
			String status = sc.next();
			
			reimbursementDAO.updateReimbursementStatus(index, status);
			break;
			}
			case 7:{
				Reimbursement reimbursement = new Reimbursement();
				System.out.println("Enter new reimbursement ID: ");
				reimbursement.setReimbursementId(sc.nextInt());
				
				System.out.println("Enter new amount: ");
				reimbursement.setAmount(sc.nextBigDecimal());
				System.out.println("Enter employee ID: ");
				reimbursement.setEmployeeId(sc.nextInt());
				System.out.println("Enter manager ID: ");
				reimbursement.setManagerId(sc.nextInt());
				System.out.println("What is the status?");
				reimbursement.setStatus(sc.next());
				
				
				
				reimbursementDAO.insertNewReimbursementRequest(reimbursement);
				break;}
			/*case 8:
				loginDAO.validate(123, "Pass");
				System.out.println("you are logged in.");
				break;*/
		}
		
	}while(choice!=0);
	}
	
	public static int rowUpdate()
	{
		int row=0;
		String QUERY = "UPDATE dept SET dname='IT80' WHERE deptno=?";
		 try (Connection conn = ConnectionDB.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {	preparedStatement.setInt(1, 80);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.println(" Row cannot be updated");
	     }
		   return row;
	}
	
	public static int rowDelete()
	{
		int row=0;
		String QUERY = "Delete from dept where deptno = ?";
	     try (Connection conn = ConnectionDB.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {		
	    	 preparedStatement.setInt(1, 80);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.println(" Row cannot be deleted");
	     }
		   return row; 
	}
	
	
	private static void insertUsingProcedure() {
		 try (Connection conn = ConnectionDB.getConnection();
		 CallableStatement stmt=conn.prepareCall("{call INSERTROWS(?,?,?)}"))
	     {	 stmt.setInt(1,77);  
			 stmt.setString(2,"dept77");  
			 stmt.setString(3,"loc77");
			 stmt.execute();
	     } catch (SQLException e) {
			e.printStackTrace();
		}
	}

/*
public void getAllEmployees() {
    List<User> employees = new LinkedList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try (Connection connection = ConnectionDB.getConnection()) {
        String sql = "select * from employee";
        
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("EmployeeID");
            System.out.println(id);
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int managerId = rs.getInt("ManagerID");
            String password = rs.getString("Password");
            String employeeType = rs.getString("EmployeeType");
            
            System.out.println("You are connected...");
            System.out.println(id + "," + firstName + lastName + "," + managerId + "," + password + "," + employeeType);

            //employees.add(new User(id, firstName, lastName, managerId, password, employeeType));
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

    //return employees;
}*/
}