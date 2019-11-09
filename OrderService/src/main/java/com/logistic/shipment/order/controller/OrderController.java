package com.logistic.shipment.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.shipment.order.model.Customer;
import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;
import com.logistic.shipment.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderedService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@PostMapping(value = "/{cust_id}/placeOrder")
	public String orderService(@Valid @RequestBody Order order, @PathVariable("cust_id") String cust_id,
			BindingResult br) {
		logger.info("Entered into the orderService Postmapping ");
		long customer_id = Long.parseLong(cust_id);
		logger.debug("Adding order for the customer id  :"+customer_id);
		if (br.hasErrors()) {
			
			List<FieldError> errors = br.getFieldErrors();
			List<String> message = new ArrayList<>();

			for (FieldError e : errors) {
				message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
			}
			logger.error("orderService has error :"+message);
		}
		long order_id = orderedService.save(order, customer_id);
		logger.info("Exit from orderService Postmapping");
		return "Successfully created order with order ID : "+order_id;
	}

	

}
