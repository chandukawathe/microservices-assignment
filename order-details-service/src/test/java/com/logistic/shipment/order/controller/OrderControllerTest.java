package com.logistic.shipment.order.controller;

import javax.persistence.EntityManager;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.logistic.shipment.order.repository.OrderRepository;
import com.logistic.shipment.order.service.OrderDetailsService;

@SpringBootTest
public class OrderControllerTest {
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	OrderDetailsService orderedService;

	public OrderControllerTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	

}
