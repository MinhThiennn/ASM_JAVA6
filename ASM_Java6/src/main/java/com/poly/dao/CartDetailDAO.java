package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.CartDetail;

public interface CartDetailDAO extends JpaRepository<CartDetail, Integer>{

}
