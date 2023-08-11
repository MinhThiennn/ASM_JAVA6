package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
	Account findByEmail(String email);
	Optional<Account> findByUsername(String username);
}
