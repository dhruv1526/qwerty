package com.cg.service;

import com.cg.bean.FeedbackMaster;

public interface IServiceParticipant {
	Boolean validate(int id);
	int insertFeedback(FeedbackMaster fm);
}
