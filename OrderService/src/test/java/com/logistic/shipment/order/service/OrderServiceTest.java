package com.logistic.shipment.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.logistic.shipment.order.model.Customer;
import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;

@SpringBootTest
public class OrderServiceTest {

	private EntityManager entityManager;

	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	public OrderServiceTest() {
		orderService = new OrderService();
		entityManager = Mockito.mock(EntityManager.class);
		orderRepository = Mockito.mock(OrderRepository.class);
	}

	@Test
	public void testSave() {

		Order order = Mockito.mock(Order.class);
		Customer customer = Mockito.mock(Customer.class);
		Mockito.when(entityManager.find(Customer.class, 1L)).thenReturn(customer);
		order.setCustomer(customer);
		Mockito.when(orderRepository.save(order)).thenReturn(order);
		Mockito.when(order.getOrder_id()).thenReturn(1L);
		assertEquals(order.getOrder_id(), 1L);

	}

}
