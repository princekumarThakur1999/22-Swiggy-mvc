package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.request.OrderRequest;
import com.swiggy.response.OrderResponse;
import com.swiggy.service.OrderService;

@RestController
@RequestMapping(path="/order")
public class OrderController {
	
	@Autowired
	OrderService odrservice;
	
	@RequestMapping(method=RequestMethod.GET, path ="/welcome")
	public String getSwiggy() {
		
		return "Welcome to Swiggy application";
	}
	
	@PostMapping("/items")
	public String addOderItems(@RequestBody OrderRequest odrreq) //@RequestBody annotation will take data from HTTP and convert into java obj 
	{
		System.out.println(odrreq.getOrderId());
		System.out.println(odrreq.getOrderItem());
		System.out.println(odrreq.getOrderValue());
		
		String srvcResp = odrservice.OrderItemAdded(odrreq); //passing odrreq obj to service layer
		
		return srvcResp ;
	}
	
	@GetMapping("/fetch")
	public OrderResponse getOrderDetails() {
		
		String orderid = "OD23343";
		OrderResponse odrrep = odrservice.getOrderDetails(orderid);
		
		return odrrep;
	}
	
	@GetMapping("/fetch/all")
	public List<OrderResponse> fetchAllOrder() {
		
		//Storing all orderReponse from service layer to Controller layer
		List<OrderResponse> oders = odrservice.fetchAllOrder();
		
		//Spring Automatically converting JAVA to JSON
		return oders;
	}
	
}
