package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	String username;
	String password;
	String email;
	Integer admin;
	String fullname;	
	String sdt;
	String address;
	Integer activated;
	String image;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Favorite> favorites;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Cart> carts;
}
