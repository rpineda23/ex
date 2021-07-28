package com.ex.db;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ex.Reimbursement;

public class ReimbursementDAO {
	Reimbursement reimbursement = new Reimbursement();
    public void getAllReimbursementsForManager(int managerId) {
        /*List<Reimbursement> reimbursements = new LinkedList<Reimbursement>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = ConnectionDB.getConnection()) {
            String sql = "select * from Reimbursement where ManagerID=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, managerId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int rid = rs.getInt("ReimbursementID");
                BigDecimal amount = rs.getObject("Amount", BigDecimal.class);
                int eid = rs.getInt("EmployeeID");
                int mid = rs.getInt("ManagerID");
                int status = rs.getInt("Approved");
                Status rstatus = Status.PENDING;

                switch (status) {
                    case 1:
                        rstatus = Status.APPROVED;
                        break;
                    case 2:
                        rstatus = Status.DISAPPROVED;
                        break;
               
                      }

                //reimbursements.add(new Reimbursement(rid, amount, eid, mid, rstatus));
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

        return reimbursements;*/
    	  PreparedStatement ps = null;
          ResultSet rs = null;

          try(Connection connection = ConnectionDB.getConnection()) {
              String sql = "select * from Reimbursement where ManagerID=?";
              ps = connection.prepareStatement(sql);
              ps.setInt(1, managerId);
              rs = ps.executeQuery();
              
              while(rs.next()) {
                  reimbursement.setReimbursementId( rs.getInt("ReimbursementID"));
                  reimbursement.setAmount(rs.getObject("Amount", BigDecimal.class));
                  reimbursement.setEmployeeId(rs.getInt("EmployeeID"));
                  reimbursement.setManagerId(rs.getInt("ManagerID"));
                  reimbursement.setStatus(rs.getString("Approved"));

                  reimbursement.toString(reimbursement.getReimbursementId(), reimbursement.getAmount(), reimbursement.getEmployeeId(), reimbursement.getManagerId(),reimbursement.getStatus());
                  
                  
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

    public void getAllReimbursementsForEmployee(int employeeId) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = ConnectionDB.getConnection()) {
            String sql = "select * from Reimbursement where EmployeeID=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                reimbursement.setReimbursementId( rs.getInt("ReimbursementID"));
                reimbursement.setAmount(rs.getObject("Amount", BigDecimal.class));
                reimbursement.setEmployeeId(rs.getInt("EmployeeID"));
                reimbursement.setManagerId(rs.getInt("ManagerID"));
                reimbursement.setStatus(rs.getString("Approved"));

                reimbursement.toString(reimbursement.getReimbursementId(), reimbursement.getAmount(), reimbursement.getEmployeeId(), reimbursement.getManagerId(),reimbursement.getStatus());
                
                
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

    public void updateReimbursementStatus(int reimbursementId, String status) {
    	CallableStatement cs = null;

        try(Connection connection = ConnectionDB.getConnection()) {
            String sql = "update reimbursement set approved =? where reimbursementId=?";
            cs = connection.prepareCall(sql);
            cs.setString(1, status);
            cs.setInt(2, reimbursementId);

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

    public void insertNewReimbursementRequest(Reimbursement reimbursement) {
        CallableStatement cs = null;

        try (Connection connection = ConnectionDB.getConnection()){
            String sql = "insert into reimbursement values (?,?,?,?,?)";
            cs = connection.prepareCall(sql);
            cs.setInt(1, reimbursement.getReimbursementId());
            cs.setBigDecimal(2, reimbursement.getAmount());
            cs.setInt(3, reimbursement.getEmployeeId());
            cs.setInt(4, reimbursement.getManagerId());
            cs.setString(5, reimbursement.getStatus());

            cs.execute();
            cs.close();
        } catch (SQLException e) {
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