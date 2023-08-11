package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
<<<<<<< HEAD
	//String email;
	Integer admin;
=======
	String email;
	Boolean admin;
>>>>>>> f116c7ac0dab46974b91c399d8283f0e5908798e
	String fullname;	
	String sdt;
	String address;
	Boolean activated;
	String image;	
	
	@Column(unique = true)
	String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Favorite> favorites;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Cart> carts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
}
