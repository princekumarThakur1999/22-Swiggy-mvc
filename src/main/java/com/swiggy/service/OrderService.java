package com.swiggy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.entity.OrderItems;
import com.swiggy.repository.OrderRepository;
import com.swiggy.request.OrderRequest;
import com.swiggy.response.OrderResponse;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public OrderResponse getOrderDetails(String orderId) {
		
		OrderItems oders = orderRepository.findById(orderId).get();
		OrderResponse orderresponse = new OrderResponse();
		orderresponse.setOrderId(oders.getOrderId());
		orderresponse.setOrderItem(oders.getOrderItem());
		orderresponse.setOrderValue(oders.getOrderValue());
		
		return orderresponse;
	}
	
	public String OrderItemAdded(OrderRequest odrreq) {
		
		OrderItems odritm = new OrderItems(); //create a entity objec
		odritm.setOrderId(odrreq.getOrderId());
		odritm.setOrderItem(odrreq.getOrderItem());
		odritm.setOrderValue(odrreq.getOrderValue());
		
		orderRepository.save(odritm);
		
		return "Service layer ordered your data";
	}
	
}
