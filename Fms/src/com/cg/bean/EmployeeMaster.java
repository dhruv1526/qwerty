package com.cg.bean;

public class EmployeeMaster {

     private int Employee_ID;
     
     private String EmployeeName;
     
     private String Password;
     
     private String Role;

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public EmployeeMaster(int employee_ID, String employeeName,
			String password, String role) {
		super();
		Employee_ID = employee_ID;
		EmployeeName = employeeName;
		Password = password;
		Role = role;
	}

	public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Employee_Master [Employee_ID=" + Employee_ID
                + ", EmployeeName=" + EmployeeName + ", Password=" + Password
                + ", Role=" + Role + "]";
    }

    
}


