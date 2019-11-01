package com.logistic.shipment.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logistic.shipment.order.model.Customer;
import com.logistic.shipment.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByCustomer(Customer customer);

}
