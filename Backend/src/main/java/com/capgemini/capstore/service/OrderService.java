package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.bean.OrderHistoryBean;

public interface OrderService {
	public List<OrderHistoryBean> getOrderHistory();
	public boolean cancelOrder(int orderId);
	public OrderDetailsBean shippingDetils(OrderDetailsBean orderDetailsBean);
	public List<OrderDetailsBean> getOrderList();
	public boolean updateShippingDetails(OrderDetailsBean orderDetailsBean);
}
