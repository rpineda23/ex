package com.ex;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class ReimbursementTest {
    private Reimbursement reimbursement;
    @Before
    public void initialize() {
        reimbursement = new Reimbursement(215, new BigDecimal("200.1"), 2020, 333,"Approved");
    }

    @Test
    public void getReimbursementIdTest() {
        assertEquals(215, reimbursement.getReimbursementId());
    }

    @Test
    public void getAmountTest() {
        assertEquals(new BigDecimal("200.1"), reimbursement.getAmount());
    }

    @Test
    public void getEmployeeIdTest() {
        assertEquals(2020, reimbursement.getEmployeeId());
    }

    @Test
    public void getManagerIdTest() {
        assertEquals(333, reimbursement.getManagerId());
    }

    
    @Test
    public void getStatusTest() {
        assertEquals("Approved", reimbursement.getStatus());
    }
}