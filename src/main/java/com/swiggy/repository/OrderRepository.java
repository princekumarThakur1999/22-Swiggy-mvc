package com.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.entity.OrderItems;

@Repository
public interface OrderRepository extends JpaRepository<OrderItems, String>{

}
