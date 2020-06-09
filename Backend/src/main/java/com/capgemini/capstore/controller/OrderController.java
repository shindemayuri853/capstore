package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.response.CapstoreResponse;
import com.capgemini.capstore.service.OrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/orderHistory")
	public CapstoreResponse orderHistory() {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		List<OrderHistoryBean> orderHistoryList = orderService.getOrderHistory();
		capstoreResponse.setStatusCode(201);
		capstoreResponse.setMessage("Success");
		capstoreResponse.setDescription("Order History List");
		capstoreResponse.setOrderHistory(orderHistoryList);
		return capstoreResponse;
	}// end of orderHistory()

	@PostMapping(path = "/shippingDetails")
	public CapstoreResponse shippingDetails(@RequestBody OrderDetailsBean orderDetailsBean) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		OrderDetailsBean insertDetails = orderService.shippingDetils(orderDetailsBean);
		if (insertDetails != null) {
			capstoreResponse.setStatusCode(201);
			capstoreResponse.setMessage("Success");
			capstoreResponse.setDescription("Shipping Details Added");
		}
		return capstoreResponse;
	}// end of shippingDetails

	@GetMapping(path = "/orderList")
	public CapstoreResponse orderList() {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		List<OrderDetailsBean> orderList1 = orderService.getOrderList();
		capstoreResponse.setStatusCode(201);
		capstoreResponse.setMessage("Success");
		capstoreResponse.setDescription("Order List");
		capstoreResponse.setOrderList(orderList1);
		return capstoreResponse;
	}

	@PostMapping(path = "/updateShippingDetails")
	public CapstoreResponse updateShipping(@RequestBody OrderDetailsBean orderDetailsBean) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		orderService.updateShippingDetails(orderDetailsBean);
		capstoreResponse.setStatusCode(201);
		capstoreResponse.setMessage("Success");
		capstoreResponse.setDescription("Updated successfully.......");
		return capstoreResponse;
	}

	@DeleteMapping(path = "/cancelOrder")
	public CapstoreResponse cancelOrder(@RequestParam int orderId) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		orderService.cancelOrder(orderId);
		capstoreResponse.setStatusCode(201);
		capstoreResponse.setMessage("Success");
		capstoreResponse.setDescription("Order Cancelled successfully.......");
		return capstoreResponse;
	}
}
