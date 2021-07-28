package com.ex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
    private User employee;
    private User manager;

    @Before
    public void initialize() {
        employee = new User(2020, "Kai", "Bento", 300, "password", "Normal");
        manager = new User(300, "Andrea", "Perez", 333,  "word", "Manager");
    }

    @Test
    public void getEmployeeIdTest() {
        assertEquals(1, employee.getEmployeeId());
    }
    
    @Test
    public void getFirstNameTest() {
        assertEquals("Kai", employee.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("Bento", employee.getLastName());
    }

    @Test
    public void getManagerIdTest() {
        assertEquals(manager.getEmployeeId(), employee.getManagerId());
    }

    

    @Test
    public void getPasswordTest() {
        assertEquals("password", employee.getPassword());
    }

    @Test
    public void getEmployeeTypeTest() {
        assertEquals("Normal", employee.getEmployeeType());
        assertEquals("Manager", manager.getEmployeeType());
    }
}
