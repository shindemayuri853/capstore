package com.capgemini.capstore.response;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CapstoreResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<CommonFeedbackBean> commonFeedbackList;
	private List<OrderHistoryBean> orderHistory;
	private List<OrderDetailsBean> orderList;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommonFeedbackBean> getCommonFeedbackList() {
		return commonFeedbackList;
	}
	public void setCommonFeedbackList(List<CommonFeedbackBean> commonFeedbackList) {
		this.commonFeedbackList = commonFeedbackList;
	}
	public List<OrderHistoryBean> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(List<OrderHistoryBean> orderHistory) {
		this.orderHistory = orderHistory;
	}
	public List<OrderDetailsBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderDetailsBean> orderList) {
		this.orderList = orderList;
	}

}
