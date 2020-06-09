package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CustomerTemporaryBean;
import com.capgemini.capstore.bean.OrderDetailsBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.exception.FetchNullListException;
import com.capgemini.capstore.exception.UnableToAddException;
import com.capgemini.capstore.exception.UnableToUpdateException;

@Repository
public class OrderDAOImplementation implements OrderDAO {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<OrderHistoryBean> getOrderHistory() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<OrderHistoryBean> orderHistory = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "FROM OrderHistoryBean";
			Query query = entityManager.createQuery(jpql);
			orderHistory = query.getResultList();
			entityManager.close();

		} catch (Exception exception) {
			throw new FetchNullListException();
		}
		return orderHistory;
	}

	
	@Override
	public List<OrderDetailsBean> getOrderList() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<OrderDetailsBean> listOrder = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql="from OrderDetailsBean";
			Query query = entityManager.createQuery(jpql);
			listOrder = query.getResultList();
			entityManager.close();
		} catch (Exception exception) {
			throw new FetchNullListException();
		}
		return listOrder;
	}

	@Override
	public boolean cancelOrder(int orderId) {
			boolean orderCancelled = false;
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpqlDeleteData = "delete from OrderDetailsBean where orderId=:orderId";
//			String jpqlInsertData = "insert into OrderBean where orderId=:orderId";
			try {
				Query queryDeleteData = entityManager.createQuery(jpqlDeleteData);
				queryDeleteData.setParameter("orderId", orderId);
				entityTransaction.begin();
				int result = queryDeleteData.executeUpdate();
				entityTransaction.commit();
				if (result > 0) {
					orderCancelled = true;
				} else {
					orderCancelled = false;
				}
			} catch (Exception exception) {
				throw new UnableToUpdateException();
			}
			return orderCancelled;
		}
	@Override
	public boolean updateShippingDetails(OrderDetailsBean orderDetailsBean) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		OrderDetailsBean existingData = entityManager.find(OrderDetailsBean.class, orderDetailsBean.getOrderId());
		System.out.println(existingData.getOrderId());
		boolean updated = false;
		if (existingData != null) {

			String email = orderDetailsBean.getEmail();
			if (email != null) {
				existingData.setEmail(email);
			}

			String address = orderDetailsBean.getAddress();
			if (address != null) {
				existingData.setAddress(address);
			}

			String pinCode = orderDetailsBean.getPincode();
			if (pinCode != null) {
				existingData.setPincode(pinCode);
			}

			String phoneNumber = orderDetailsBean.getPhoneNumber();
			if (phoneNumber!= null) {
				existingData.setPhoneNumber(phoneNumber);
			}
			int productQuantity= orderDetailsBean.getProductQuantity();
			if (productQuantity>0) {
				existingData.setProductQuantity(productQuantity);
			}
			double totalBill= orderDetailsBean.getTotalBill();
			if (totalBill >0) {
				existingData.setTotalBill(totalBill);
			}
			try {
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(existingData);
				entityTransaction.commit();
				updated = true;
			} catch (Exception e) {
				throw new UnableToUpdateException();
			}
			entityManager.close();
		}
		return updated;

	}

	@Override
	public OrderDetailsBean shippingDetils(OrderDetailsBean orderDetailsBean) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		CustomerTemporaryBean customerTemporaryBean = new CustomerTemporaryBean();
		double bill;
		int quantity = orderDetailsBean.getProductQuantity();
		ProductBean productBean = new ProductBean();
		double price = productBean.getProductPrice();
		bill = quantity*price;
		orderDetailsBean.setProductId(productBean.getProductId());
		orderDetailsBean.setEmail(customerTemporaryBean.getEmail());
		orderDetailsBean.setAddress(orderDetailsBean.getAddress());
		orderDetailsBean.setPincode(orderDetailsBean.getPincode());
		orderDetailsBean.setPhoneNumber(orderDetailsBean.getPhoneNumber());
		orderDetailsBean.setProductQuantity(quantity);
		orderDetailsBean.setTotalBill(bill);
			entityTransaction.begin();
			entityManager.persist(orderDetailsBean);
			entityTransaction.commit();
		} catch (Exception e) {
			throw new UnableToAddException();
		}
		return orderDetailsBean;
	}

}






