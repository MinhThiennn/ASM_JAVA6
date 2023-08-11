package com.poly.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;

public interface OrderService {
	
	Order create(JsonNode orderData);
}
