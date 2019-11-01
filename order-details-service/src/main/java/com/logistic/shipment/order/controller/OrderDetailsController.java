package com.logistic.shipment.order.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;
import com.logistic.shipment.order.service.OrderDetailsService;

@RestController
public class OrderDetailsController {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	EntityManager entityManager;
    
	@Autowired
    OrderDetailsService orderedService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);


	@RequestMapping("/{cust_id}/getOrders")
	public List<Order> getOrdersById(@PathVariable("cust_id") long cust_id) {
	    
		logger.info("Entered into getOrdersById");
		
		List<Order> orderList=orderedService.getOrdersByCust_id(cust_id);
		
		logger.info("Orders list retrieved successfully");
		
		return orderList;
	}

}
