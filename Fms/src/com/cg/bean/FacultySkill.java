package com.cg.bean;

public class FacultySkill {
	int fId;
	String skill;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
				return "           " + fId + "        " + skill ;
	}
	public FacultySkill(int fId, String skill) {
		super();
		this.fId = fId;
		this.skill = skill;
	}
 

}
