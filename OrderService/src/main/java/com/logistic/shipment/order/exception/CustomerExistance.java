package com.logistic.shipment.order.exception;

public class CustomerExistance extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerExistance(String message) {
		super(message);
	}

}
