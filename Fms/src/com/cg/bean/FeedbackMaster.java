package com.cg.bean;

public class FeedbackMaster {


    private int Training_Code;
    
    private int  Participant_Id;
    
    private int FB_Prs_comm;
    
    private int FB_Clrfy_dbts;
    
    private int  FB_TM;
    
    private int FB_Hnd_out;
    
    private int FB_Hw_Sw_Ntwrk;
    
    private String Comments;
    
    private String  Suggestions;

    public int getTraining_Code() {
        return Training_Code;
    }

    public void setTraining_Code(int training_Code) {
        Training_Code = training_Code;
    }

    public int getParticipant_Id() {
        return Participant_Id;
    }

    public void setParticipant_Id(int participant_Id) {
        Participant_Id = participant_Id;
    }

    public int getFB_Prs_comm() {
        return FB_Prs_comm;
    }

    public void setFB_Prs_comm(int fB_Prs_comm) {
        FB_Prs_comm = fB_Prs_comm;
    }

    public int getFB_Clrfy_dbts() {
        return FB_Clrfy_dbts;
    }

    public void setFB_Clrfy_dbts(int fB_Clrfy_dbts) {
        FB_Clrfy_dbts = fB_Clrfy_dbts;
    }

    public int getFB_TM() {
        return FB_TM;
    }

    public void setFB_TM(int fB_TM) {
        FB_TM = fB_TM;
    }

    public int getFB_Hnd_out() {
        return FB_Hnd_out;
    }

    public void setFB_Hnd_out(int fB_Hnd_out) {
        FB_Hnd_out = fB_Hnd_out;
    }

    public int getFB_Hw_Sw_Ntwrk() {
        return FB_Hw_Sw_Ntwrk;
    }

    public void setFB_Hw_Sw_Ntwrk(int fB_Hw_Sw_Ntwrk) {
        FB_Hw_Sw_Ntwrk = fB_Hw_Sw_Ntwrk;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getSuggestions() {
        return Suggestions;
    }

    public void setSuggestions(String suggestions) {
        Suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "Feedback_Master [Training_Code=" + Training_Code
                + ", Participant_Id=" + Participant_Id + ", FB_Prs_comm="
                + FB_Prs_comm + ", FB_Clrfy_dbts=" + FB_Clrfy_dbts + ", FB_TM="
                + FB_TM + ", FB_Hnd_out=" + FB_Hnd_out + ", FB_Hw_Sw_Ntwrk="
                + FB_Hw_Sw_Ntwrk + ", Comments=" + Comments + ", Suggestions="
                + Suggestions + "]";
        
    }
	
	
}
