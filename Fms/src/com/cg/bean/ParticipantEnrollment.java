package com.cg.bean;

public class ParticipantEnrollment {
	
	
	int trainingCode;
	int participantId;
	
	public ParticipantEnrollment() {
		// TODO Auto-generated constructor stub
	}
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	
	public ParticipantEnrollment(int trainingCode, int participantId) {
		super();
		this.trainingCode = trainingCode;
		this.participantId = participantId;
		
	
	

}
	@Override
	public String toString() {
		return "paticipantEnrollment [trainingCode=" + trainingCode
				+ ", participantId=" + participantId + "]";
	}
}
