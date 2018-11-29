package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;

public interface IService {
public Boolean isValid(int eid,String pass);
public Boolean checkInt(String num);
public Boolean validatePID(int pId);

public String validate(int eid, String pass);
void show();
public Boolean validateTID(int tId);
public ArrayList<FacultySkill> showSkill();
public Boolean validateFID(int fId);
public ArrayList<EmployeeMaster> showEmployees();
public Boolean validateCID(int cId);
}
