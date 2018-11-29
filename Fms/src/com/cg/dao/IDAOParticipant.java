package com.cg.dao;

import com.cg.bean.FeedbackMaster;

public interface IDAOParticipant {
	Boolean validate(int id);
	int insertFeedback(FeedbackMaster fm);
}
