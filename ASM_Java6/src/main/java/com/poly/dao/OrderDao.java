package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
