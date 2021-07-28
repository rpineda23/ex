package com.ex;

import java.math.BigDecimal;

public class Reimbursement {
    private int reimbursementId;
    private BigDecimal amount;
    private int employeeId;
    private int managerId;
    private String status;

    public Reimbursement() {}

    public Reimbursement(BigDecimal amount, int employeeId, int managerId, String status) {
        this.amount = amount;
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.status = status;
    }

    public Reimbursement (int reimbursementId, BigDecimal amount, int employeeId, int managerId,String status) {
        this.reimbursementId = reimbursementId;
        this.amount = amount;
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.status = status;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the reimbursementId
     */
    public int getReimbursementId() {
        return reimbursementId;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void toString(int reimbursementId, BigDecimal amount, int employeeId, int managerId, String status) {
		System.out.println("Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", employeeId=" + employeeId
				+ ", managerId=" + managerId + ", status=" + status + "]");
	}

	/**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    /**
     * @param reimbursementId the reimbursementId to set
     */
    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}
