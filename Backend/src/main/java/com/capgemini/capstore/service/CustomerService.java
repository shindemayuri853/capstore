package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;

public interface CustomerService {
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean);

	public List<CommonFeedbackBean> getCommonFeedbackList();
}
