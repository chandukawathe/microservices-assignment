package com.logistic.shipment.order.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.shipment.order.exception.CustomerNotFoundException;
import com.logistic.shipment.order.model.Customer;
import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;

@Service
public class OrderDetailsService {

	@Autowired
	private EntityManager entityManager;
    
	@Autowired
	OrderRepository orderRepository;
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailsService.class);
   
	public List<Order> getOrdersByCust_id(long cust_id)
     {
		logger.info("Entered into the getOrdersByCust_id( )");
	   Customer customer = entityManager.find(Customer.class, cust_id);
	   if(customer==null)
	   {
		   throw new CustomerNotFoundException("Customer with id : "+cust_id+"doesn't exist");
	   }
	   List<Order> orderList = orderRepository.findByCustomer(customer);
	   return orderList;
     }

}
