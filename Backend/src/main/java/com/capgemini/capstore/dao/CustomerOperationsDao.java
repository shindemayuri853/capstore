package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;

public interface CustomerOperationsDao {

	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean);

	public List<CommonFeedbackBean> getCommonFeedbackList();
	
}
