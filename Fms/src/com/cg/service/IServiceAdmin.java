package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.CourseMaster;
import com.cg.bean.FacultySkill;

public interface IServiceAdmin {

	void facultySkillMaintenance();

	ArrayList<CourseMaster> courseMaintenance();

	void viewReport();

	int addFacultySkill(FacultySkill facultySkill);

	int updateCourse(CourseMaster course);



}
