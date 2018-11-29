package com.cg.bean;

public class CourseMaster {

  private int Course_ID;
  
  private String Course_Name;
  
  private int No_of_Days;

public int getCourse_ID() {
    return Course_ID;
}

public CourseMaster(int course_ID, String course_Name, int no_of_Days) {
	super();
	Course_ID = course_ID;
	Course_Name = course_Name;
	No_of_Days = no_of_Days;
}

public void setCourse_ID(int course_ID) {
    Course_ID = course_ID;
}

public String getCourse_Name() {
    return Course_Name;
}

public void setCourse_Name(String course_Name) {
    Course_Name = course_Name;
}

public int getNo_of_Days() {
    return No_of_Days;
}

public void setNo_of_Days(int no_of_Days) {
    No_of_Days = no_of_Days;
}

@Override
public String toString() {
    return "          "+Course_ID + "            "+ No_of_Days+"              "+ Course_Name ;
}


}