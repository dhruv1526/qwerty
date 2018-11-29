package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.TrainingProgram;
import com.cg.util.DBUtil;

public class DaoCoord implements IDaoCoord {
   Connection conn;
   Logger myLogger =  Logger.getLogger(DaoCoord.class.getName( ));
	public DaoCoord(){
		conn=DBUtil.getConnection();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	ArrayList<TrainingProgram> al=new ArrayList<TrainingProgram>();
	TrainingProgram program;
	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() 
	{
	String query="select * from training_program";
	try
	{
		PreparedStatement statement=  conn.prepareStatement(query);
		ResultSet rset= statement.executeQuery();
		
		while(rset.next())
		{
			int trainingCode=rset.getInt(1);
			int courseCode=rset.getInt(2);
			int facultyCode=rset.getInt(3);
			String startdate=rset.getString(4);
			String endDate=rset.getString(5);
			program=new TrainingProgram(trainingCode,courseCode,facultyCode,startdate,endDate);
			al.add(program);
			//System.out.println(program);
			
		}
		myLogger.info("Training Details : " );
	}
	catch (SQLException e) {
		
		myLogger.error("Exception found  " +e);
		//e.printStackTrace();
	}
	return al;
	}
	@Override
	public Boolean validate(int id) {
	String query="Select training_code from training_program where training_code=?";
	ResultSet resultSet=null;
	try {
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setInt(1, id);
		resultSet=stmt.executeQuery();
		myLogger.info("Training code Selected: " + id); 
	} catch (SQLException e) {
		
		myLogger.error("Exception found  " +e);
		//e.printStackTrace();
	}	if(resultSet==null)
	{
		return false;
	}
	else return true;
		
	}
	@Override
	public Boolean validateCID(int id) {
		String query="select course_ID from Course_master where Course_ID=?";
		ResultSet resultSet=null;
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, id);
			resultSet=stmt.executeQuery();
			myLogger.info("Course Id Selected: "+ id );
		} catch (SQLException e) {
			
			myLogger.error("Exception found  " +e);
			//e.printStackTrace();
		}	if(resultSet==null)
		{
			return false;
		}
		else return true;
	}
	@Override
	public Boolean validateFID(int fId) {
		
		String query="select Employee_ID from Employee_master where Employee_ID=? and Role='Faculty'";
		ResultSet resultSet=null;
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, fId);
			resultSet=stmt.executeQuery();
			
		} catch (SQLException e) {
			
			myLogger.error("Exception found  " +e);
			//e.printStackTrace();
		}	if(resultSet==null)
		{
			return false;
		}
		
		else
		{
			myLogger.info("Employee Id selected: " + fId);
		return true;
		}
	}
	@Override
	public int updateProgram(TrainingProgram trainingProgram) {
		java.sql.Date startDate = null;
		int result = 0;
		java.util.Date date2;
		java.sql.Date endDate = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date;
		try {
			date = sdf1.parse(trainingProgram.getStartdate());
		
		 startDate = new java.sql.Date(date.getTime());
		 date2 = sdf1.parse(trainingProgram.getEndDate());
		 endDate = new java.sql.Date(date2.getTime());
		
		} catch (ParseException e1) {
		                       	// TODO Auto-generated catch block
			
		
			//e1.printStackTrace();
		}
		
		
		String query="update Training_Program Set course_code=?, Faculty_code=?,Start_Date=?,End_Date=? where Training_code=?"; 
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1,trainingProgram.getCourseCode());
			stmt.setInt(2,trainingProgram.getFacultyCode());
			stmt.setDate(3, startDate);
			stmt.setDate(4, endDate);
			stmt.setInt(5, trainingProgram.getTrainingCode());
		 result=stmt.executeUpdate();
		 myLogger.info("Records updated: " +trainingProgram );
		} catch (SQLException e) {
			
			myLogger.error("Exception found  " +e);
			//e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	@Override                         //ADDING NEW TRAINING PROGRAM 
	public Boolean addProgram(TrainingProgram trainingProgram) {
		java.sql.Date startDate = null;
		int result = 0;
		java.util.Date date2;
		java.sql.Date endDate = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date;
		try {
			date = sdf1.parse(trainingProgram.getStartdate());
		
		 startDate = new java.sql.Date(date.getTime());
		 date2 = sdf1.parse(trainingProgram.getEndDate());
		 endDate = new java.sql.Date(date2.getTime());
		 
		} catch (ParseException e1) {
			
		                       	// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		String query="insert into Training_program values(?,?,?,?,?)";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(2,trainingProgram.getCourseCode());
			stmt.setInt(3,trainingProgram.getFacultyCode());
			stmt.setDate(4, startDate);
			stmt.setDate(5, endDate);
			stmt.setInt(1, trainingProgram.getTrainingCode());
			result=stmt.executeUpdate();
			if(result>0)
			{
				myLogger.info("Record Inserted: " + trainingProgram);
				return true;}
			else
				return false;
			
		} catch (SQLException e) {
			myLogger.error("Exception found  " +e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	
		return false;
	}
	@Override
	public int removeProgram(int id) {
		int result = 0;
		String query="delete from Training_Program where Training_Code=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1, id);
			result=stmt.executeUpdate();
			myLogger.info("Record deleted: " +id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			myLogger.error("Exception found  " +e);
			//e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public int enrollParticipant(ParticipantEnrollment enroll) {
		int x = 0;
		String sql="INSERT INTO TRAINING_PARTICIPANT_ENROLLMENT VALUES(?,?)"; 
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
					
			
			statement.setInt(1,enroll.getTrainingCode());
			statement.setInt(2,enroll.getParticipantId());
			
			
			
			x=statement.executeUpdate();
			//System.out.println("Enrolled Successful ..");
			myLogger.info("Record Inserted: " + enroll);
			
		
		} catch (SQLException e) {
			myLogger.error("Exception found  " +e);
			//e.printStackTrace();
			
			
			
		}
			
		return x;
		
	}

}
