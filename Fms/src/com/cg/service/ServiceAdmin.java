package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.CourseMaster;
import com.cg.bean.FacultySkill;
import com.cg.dao.DaoAdmin;
import com.cg.dao.IDaoAdmin;

public class ServiceAdmin implements IServiceAdmin{
    IDaoAdmin ad= new DaoAdmin();  
	@Override
	public void facultySkillMaintenance() {
		
		
	}

	@Override
	public ArrayList<CourseMaster> courseMaintenance() {
		return ad.courseMaintenance();
		
		
	}

	@Override
	public void viewReport() {
		
		
	}
  Boolean validate(int id)
  {
//	  if
	 return ad.validate(id); 
	  
	  
	  
  }

@Override
public int addFacultySkill(FacultySkill facultySkill) {
	
	return ad.addFacultySkill(facultySkill);
}

@Override
public int updateCourse(CourseMaster course) {
	// TODO Auto-generated method stub
	return ad.updateCourse(course);
}


}
