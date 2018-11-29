package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.CourseMaster;
import com.cg.bean.FacultySkill;

public interface IDaoAdmin {

	Boolean validate(int id);

	int addFacultySkill(FacultySkill facultySkill);

	ArrayList<CourseMaster> courseMaintenance();

	int updateCourse(CourseMaster course);

	

}
