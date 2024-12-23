package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//single path variable
	@GetMapping("/fetch/{orderId}")
	public OrderResponse fetchByOrderid(@PathVariable("orderId") String orderId) {
		
		//Storing orderReponse from service layer to Controller layer
		OrderResponse oders = odrservice.fetchByOrderid(orderId);
		
		//Spring Automatically converting JAVA to JSON
		return oders;
	}
	
	//multiple path variable
	@GetMapping("/fetch/value/{orderValue}/item/{odrItms}")
	public List<OrderResponse> fetchByOrderValueAndOrderItem(@PathVariable String orderValue, @PathVariable("odrItms") String orderItem){
		
		//Storing orderReponse from service layer to Controller layer
		List<OrderResponse> odrreps = odrservice.fetchByOrderValueAndOrderItem(orderValue,orderItem);
		
		//Spring Automatically converting JAVA to JSON
		return odrreps;
	}
	
	// Query Parameter 
	@GetMapping("/get")   //http://localhost:8082/22-Swiggy-app/order/get?orderitems=Chicken%20lolipop
	public List<OrderResponse> fetchByOrderitem(@RequestParam("orderitem") String orderitem){
		//it will collect the data from the request. it is key-value pair where key is orderitems and value is Chicken lolipop. value are storing into "orderitem" variable.
		
		//return "Your orderitem is " + orderitem +" is it taste.";
		
		List<OrderResponse> orderRes = odrservice.fetchByOrderitem(orderitem);
		return orderRes;
	}
	
	//Multiple Query parameter
    @GetMapping("/get/value/item")
		public List<OrderResponse> fetchByOrderValueandOrderItem(
									@RequestParam(name = "orderValue", required = false) String orderValue,
									@RequestParam(name = "odrItms", required = false) String odrItms){
			
			//Storing orderReponse from service layer to Controller layer
			List<OrderResponse> odrreps = odrservice.fetchByOrderValueandOrderItem(orderValue,odrItms);
			
			//Spring Automatically converting JAVA to JSON
			return odrreps;
		}
}
