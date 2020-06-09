package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.dao.OrderDAO;

@Service
public class OrderServiceImplementation implements OrderService {
@Autowired
private OrderDAO orderDAO;

@Override
public List<OrderHistoryBean> getOrderHistory() {
	return orderDAO.getOrderHistory();
}

@Override
public boolean cancelOrder(int orderId) {
	return orderDAO.cancelOrder(orderId);
}

@Override
public OrderDetailsBean shippingDetils(OrderDetailsBean orderDetailsBean) {
	return orderDAO.shippingDetils(orderDetailsBean);
}

@Override
public List<OrderDetailsBean> getOrderList() {
	return orderDAO.getOrderList();
}

@Override
public boolean updateShippingDetails(OrderDetailsBean orderDetailsBean) {
	return orderDAO.updateShippingDetails(orderDetailsBean);
}

}
