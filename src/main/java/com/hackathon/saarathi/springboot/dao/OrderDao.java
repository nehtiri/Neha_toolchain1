package com.hackathon.saarathi.springboot.dao;

import java.util.List;

import com.hackathon.saarathi.springboot.entity.Order;

public interface OrderDao {

	public List<Order> findAll();

	public void insertOrder(Order order);

	public void executeUpdateOrder(Order order);

	public void deleteOrder(Order order);

}
