package com.main.sbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sbp.entity.Order;
import com.main.sbp.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class CatalogController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category) {
		return orderRepository.findByCategory(category);
	}
}
