package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;

public interface IDao {
	public String validate(int eid,String pass);
	public Boolean validatePID(int pId);
	public Boolean validateTID(int tId);
	public ArrayList<FacultySkill> showSkill();
	public Boolean validateFID(int fId);
	public ArrayList<EmployeeMaster> showEmployees();
	public Boolean validateCID(int cId);


	
    
}
