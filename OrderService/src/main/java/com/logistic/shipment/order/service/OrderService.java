package com.logistic.shipment.order.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.shipment.order.exception.CustomerExistance;
import com.logistic.shipment.order.model.Customer;
import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	OrderRepository orderRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Transactional
	public long save(Order order, long cust_id) {
		logger.info("Entered into the save method");
		Customer customer = entityManager.find(Customer.class, cust_id);
		if (customer == null) {
			logger.error("Customer does not exist");
			throw new CustomerExistance("Customer does not exist");

		}
		order.setCustomer(customer);
		Order savedOrder = orderRepository.save(order);
		long ordered_id = savedOrder.getOrder_id();
		logger.info("Exit form save method");
		return ordered_id;

	}

}
