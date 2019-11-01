package com.logistic.shipment.order.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer is NotFound with respective to Customer_Id")
public class CustomerNotFoundException extends RuntimeException 
{

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
