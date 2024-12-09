package com.swiggy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="swiggy_orders")
public class OrderItems {
	
	@Id
	@Column
	private String orderId;
	
	@Column
	private String orderItem;
	
	@Column
	private String orderValue;

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(String orderId, String orderItem, String orderValue) {
		super();
		this.orderId = orderId;
		this.orderItem = orderItem;
		this.orderValue = orderValue;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}
	
	
}
