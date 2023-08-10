package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{
	
}
