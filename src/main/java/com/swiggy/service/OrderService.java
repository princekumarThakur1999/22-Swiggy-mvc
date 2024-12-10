package com.swiggy.service;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<OrderResponse> fetchAllOrder(){
		
		//fetch data from repostiory and store into entity
		List<OrderItems> odrsentity = orderRepository.findAll();
		
		//store entity object into orderResponse to send back into controller layer
		List<OrderResponse> odrs = new ArrayList<>();
		
		for(OrderItems oderitem : odrsentity) {
			
			OrderResponse oderrep = new OrderResponse();   //create a orderresponse
			oderrep.setOrderId(oderitem.getOrderId());     //setting value from entity to response
			oderrep.setOrderItem(oderitem.getOrderItem()); 
			oderrep.setOrderValue(oderitem.getOrderValue()); 
			
			odrs.add(oderrep);   //adding oderresp object into list of orderresponse
		}
		
		return odrs;
	}
	
}
