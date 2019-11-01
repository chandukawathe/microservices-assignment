package com.logistic.shipment.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "Orders")
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;

	@Column(name = "source_address")
	private String source_address;

	@Column(name = "dest_address")
	private String dest_address;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	private Date order_date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "shipment_date")
	@Temporal(TemporalType.DATE)
	private Date shipment_date;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(referencedColumnName = "cust_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "products")
	private List<Product> product;

	public Order() {
		super();
	}


	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getSource_address() {
		return source_address;
	}

	public void setSource_address(String source_address) {
		this.source_address = source_address;
	}

	public String getDest_address() {
		return dest_address;
	}

	public void setDest_address(String dest_address) {
		this.dest_address = dest_address;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getShipment_date() {
		return shipment_date;
	}

	public void setShipment_date(Date shipment_date) {
		this.shipment_date = shipment_date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
