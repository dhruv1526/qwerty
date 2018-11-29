package com.cg.service;

import java.util.ArrayList;

import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.TrainingProgram;
import com.cg.dao.DaoCoord;
import com.cg.dao.IDaoCoord;

public class ServiceCoord implements IServiceCoord{
	IDaoCoord dao=new DaoCoord();
    
	@Override
	public ArrayList<TrainingProgram> trainingMaintenance() {
		
		return dao.trainingMaintenance();
	}

	@Override
	public void paticipantEnrollment() {
		
		
	}

	@Override
	public void viewFeedback() {
		
		
		
	}

	@Override
	public Boolean validate(int id) {
	
		return dao.validate(id);
	}

	@Override
	public Boolean validateCID(int id) {
		
		return dao.validateCID(id);
	}

	@Override
	public Boolean validateFID(int fId) {
		
		return dao.validateFID(fId);
	}

	@Override
	public int updateProgram(TrainingProgram trainingProgram) {
		
		return dao.updateProgram(trainingProgram);
	}

	@Override
	public Boolean addProgram(TrainingProgram trainingProgram) {
		return dao.addProgram(trainingProgram);
		
	}

	@Override
	public int removeProgram(int id) {
		
		return dao.removeProgram(id);
	}

	@Override
	public int enrollParticipant(ParticipantEnrollment enroll) {
		
		return dao.enrollParticipant(enroll);
	}

}
