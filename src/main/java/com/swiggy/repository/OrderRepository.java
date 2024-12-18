package com.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.entity.OrderItems;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, String>{

	 OrderItems findByOrderId(String orderId);

	List<OrderItems> findByOrderValueAndOrderItem(String orderValue, String orderItem);

	List<OrderItems> findByOrderItem(String orderitem);  //this value should be same as entity and db cloumn value "OrderItem"

}
