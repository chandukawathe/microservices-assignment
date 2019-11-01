package com.logistic.shipment.order.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cust_id;

	@Column(name = "cust_name")
	private String cust_name;

	@Column(name = "cust_email")
	private String cust_email;

	@Column(name = "cust_address")
	private String cust_address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Order> order = new HashSet<Order>();

	public Customer() {
		super();

	}

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Customer(long cust_id, String cust_name, String cust_email, String cust_address, Set<Order> order) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_email = cust_email;
		this.cust_address = cust_address;
		this.order = order;
	}

}
