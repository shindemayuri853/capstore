package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.dao.CustomerOperationsDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerOperationsDao customerOperationsDao;

	@Override
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean) {
		return customerOperationsDao.insertCommonFeedback(commonFeedbackBean);
	}

	@Override
	public List<CommonFeedbackBean> getCommonFeedbackList() {
		return customerOperationsDao.getCommonFeedbackList();
	}

}
