package com.cg.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.dao.DAO;
import com.cg.dao.IDao;

public class Service implements IService{
	IDao dao=new DAO();
	



	@Override
	public String validate(int eid, String pass) {
		
	 return dao.validate(eid, pass) ;
		
	}




	@Override
	public Boolean isValid(int eid, String pass) {
		if(eid<=0||pass.isEmpty())
			return false;
			// TODO Auto-generated method stub
		return true;
	}




	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public Boolean checkInt(String num) {
	   Scanner kb=new Scanner(num);
	   if(kb.hasNextInt())
	    return true ;
	   else return false;
	}




	@Override
	public Boolean validatePID(int pId) {
		
		return dao.validatePID(pId);
	}




	@Override
	public Boolean validateTID(int tId) {
		// TODO Auto-generated method stub
		return dao.validateTID(tId);
	}




	@Override
	public ArrayList<FacultySkill> showSkill() {
		// TODO Auto-generated method stub
		return dao.showSkill();
	}




	@Override
	public Boolean validateFID(int fId) {
		return dao.validateFID(fId);
		
		
	}




	@Override
	public ArrayList<EmployeeMaster> showEmployees() {
		
		return dao.showEmployees();
	}




	@Override
	public Boolean validateCID(int cId) {
		
		return dao.validateCID(cId);
	}





	

}
