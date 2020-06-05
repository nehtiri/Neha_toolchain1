package com.hackathon.saarathi.springboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hackathon.saarathi.springboot.entity.Order;
import com.hackathon.saarathi.springboot.entity.User;

public class OrderRowMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int arg1) throws SQLException {
		Order order = new Order();
		 
		order.setOrderId(rs.getLong("order_id"));
		
		order.setItem(rs.getString("item"));
		order.setQuantity(rs.getLong("quantity"));
		order.setFulFillerId(rs.getLong("fulfiller_Id"));

		order.setReqId(rs.getLong("req_id"));
	
		return order;
	}
}
