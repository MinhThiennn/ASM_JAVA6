package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Cart;


public interface CartDAO extends JpaRepository<Cart, Integer>{
	
	@Query("Select c From Cart c where c.account.username = ?1")
	Cart findByAccountUsername(String username);
}
