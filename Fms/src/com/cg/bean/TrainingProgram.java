package com.cg.bean;

public class TrainingProgram {
	
int trainingCode;
int courseCode;
int facultyCode;
String startdate;
String endDate;
public TrainingProgram(){}
public int getTrainingCode() {
	return trainingCode;
}
public void setTrainingCode(int trainingCode) {
	this.trainingCode = trainingCode;
}
public TrainingProgram(int trainingCode, int courseCode, int facultyCode,
		String startdate, String endDate) {
	super();
	this.trainingCode = trainingCode;
	this.courseCode = courseCode;
	this.facultyCode = facultyCode;
	this.startdate = startdate;
	this.endDate = endDate;
}
public int getCourseCode() {
	return courseCode;
}
public void setCourseCode(int courseCode) {
	this.courseCode = courseCode;
}
public int getFacultyCode() {
	return facultyCode;
}
public void setFacultyCode(int facultyCode) {
	this.facultyCode = facultyCode;
}
public String getStartdate() {
	return startdate;
}
public void setStartdate(String startdate) {
	this.startdate = startdate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return "      "+ trainingCode + "                  "+ courseCode + "              " + facultyCode + "             "	+ startdate + "       " + endDate ;
}



}
