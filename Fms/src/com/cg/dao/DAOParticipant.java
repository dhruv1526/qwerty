package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bean.FeedbackMaster;
import com.cg.util.DBUtil;

public class DAOParticipant implements IDAOParticipant{
	
	
	Connection conn;
	Logger myLogger =  Logger.getLogger(DAOParticipant.class.getName( ));

	public DAOParticipant() {
		conn=DBUtil.getConnection();
		PropertyConfigurator.configure("log4j.properties");
	}


	@Override
	public Boolean validate(int id) {
		
		
		String query="Select training_code from training_program where training_code=?";
		ResultSet resultSet=null;
		try {
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, id);
			resultSet=stmt.executeQuery();
		
			
		} catch (SQLException e) {
			
			myLogger.error("Exception found  " +e); 
			//e.printStackTrace();
		}	if(resultSet==null)
		{
			return false;
		}
		else
		{	myLogger.info("Training code selected: " + id);	
			return true;
		}
			
		
	}
	@Override
	 public int insertFeedback(FeedbackMaster fm){
			
			conn=DBUtil.getConnection();
			
			int x=0;	
			String sql="INSERT INTO FEEDBACK_MASTER VALUES(?,?,?,?,?,?,?,?,?)"; 
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
						
				
				statement.setInt(1,fm.getTraining_Code());
				statement.setInt(2,fm.getParticipant_Id());
				
				statement.setInt(3,fm.getFB_Prs_comm());
				statement.setInt(4,fm.getFB_Clrfy_dbts());
				statement.setInt(5,fm.getFB_TM());
				statement.setInt(6,fm.getFB_Hnd_out());
				statement.setInt(7,fm.getFB_Hw_Sw_Ntwrk());
				statement.setString(8,fm.getComments());
				statement.setString(9,fm.getSuggestions());
				
				x=statement.executeUpdate();
				
				myLogger.info("Record inserted: " + fm);
				return x;	
			
			} catch (SQLException e) {
				
				myLogger.error("Exception found  " +e); 
				//e.printStackTrace();
				return x;		
			}
		}


}
