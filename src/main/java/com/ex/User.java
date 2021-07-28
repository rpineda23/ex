package com.ex;

public class User {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int managerId;
    private String password;
    private String employeeType;

    public User() {}

    public User (int employeeId, String firstName, String lastName, int managerId, String  password, String employeeType) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.managerId = managerId;
        this.password = password;
        this.employeeType = employeeType;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the managerId
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the employeeType
     */
    public String getEmployeeType() {
        return employeeType;
    }

    //@Override
	public String toString(User employeeId, User firstName, User lastName, User managerId, User password, User employeeType) {
		return "User [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", managerId="
				+ managerId + ", password=" + password + ", employeeType=" + employeeType + "]";
	}

	/**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param managerId the managerId to set
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param employeeType the employeeType to set
     */
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

	public void toString(int employeeId2, String firstName2, String lastName2, int managerId2, String password2,
			String employeeType2) {
		System.out.println("User [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", managerId="
				+ managerId + ", password=" + password + ", employeeType=" + employeeType + "]");
	}
}