package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bean.CourseMaster;
import com.cg.bean.FacultySkill;
import com.cg.util.DBUtil;

public class DaoAdmin implements IDaoAdmin{
	Connection conn;
	Logger myLogger =  Logger.getLogger(DaoAdmin.class.getName( ));
	public DaoAdmin()
	{
		conn=DBUtil.getConnection();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Override
	public Boolean validate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFacultySkill(FacultySkill facultySkill) {int result = 0;
		String query="UPDATE FACULTY_SKILL set Skill_Set=? where Faculty_Id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(2, facultySkill.getfId());
			stmt.setString(1,facultySkill.getSkill());
			result=stmt.executeUpdate();
			myLogger.info("Updated faculty skills: " +facultySkill); 
		} catch (SQLException e) {
			myLogger.error("Exception found  " +e); 
			//e.printStackTrace();
		}
		
		return result;
	}
	
	 CourseMaster course;
     ArrayList<CourseMaster> al=new ArrayList<CourseMaster>();
   @Override
   public ArrayList<CourseMaster> courseMaintenance() {
       // TODO Auto-generated method stub
       String query="select * from Course_Master";
       PreparedStatement statement;
       try {
           statement = conn.prepareStatement(query);
           ResultSet cset= statement.executeQuery();
           
           while(cset.next())
           {
               int Course_Id=cset.getInt(1);
               String Course_Name=cset.getString(2);
               int No_of_Days=cset.getInt(3);
               course=new CourseMaster(Course_Id,Course_Name,No_of_Days);
               al.add(course);
           }
           myLogger.info("Details found: " ); 
       } catch (SQLException e) {
           // TODO Auto-generated catch block
    	   myLogger.error("Exception found  " +e); 
           //e.printStackTrace();
       }
   
       return al;
   }
   @Override
   public int updateCourse(CourseMaster coursemaster) {
       String query="update COURSE_MASTER Set Course_Name=?, No_of_Days=? where Course_Id=?"; 
       int result = 0;
	try {
           PreparedStatement stmt= conn.prepareStatement(query);
           stmt.setString(1,coursemaster.getCourse_Name());
           stmt.setInt(2,coursemaster.getNo_of_Days());
           stmt.setInt(3, coursemaster.getCourse_ID());
          result=stmt.executeUpdate();
          myLogger.info("Records updated: " + coursemaster ); 
       } catch (SQLException e) {
    	   myLogger.error("Exception found  " +e); 
           //e.printStackTrace();
       }
       
       return result;
   }


	

}
