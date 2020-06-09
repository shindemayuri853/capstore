package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.response.CapstoreResponse;
import com.capgemini.capstore.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/insertCommonFeedback")
	public CapstoreResponse insertCommonFeedback(@RequestBody CommonFeedbackBean commonFeedbackBean) {
		CapstoreResponse response = new CapstoreResponse();
		boolean result = customerService.insertCommonFeedback(commonFeedbackBean);
		if (result) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Feedback added successfully!");
		} else {
			throw new CapstoreException("Feedback can't be added :(");
		}
		return response;
	}

	@GetMapping(path = "/getCommonFeedback")
	public CapstoreResponse getCommonFeedback() {
		CapstoreResponse response = new CapstoreResponse();
		List<CommonFeedbackBean> commonFeedbackList = customerService.getCommonFeedbackList();
		if (commonFeedbackList != null && !commonFeedbackList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Common feedback list displayed");
			response.setCommonFeedbackList(commonFeedbackList);
		} else {
			throw new CapstoreException("The feedbacks can't be displayed");
		}
		return response;
	}
}
