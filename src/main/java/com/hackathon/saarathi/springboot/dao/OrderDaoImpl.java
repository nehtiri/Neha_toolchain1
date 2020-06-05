package com.hackathon.saarathi.springboot.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hackathon.saarathi.springboot.entity.Order;
import com.hackathon.saarathi.springboot.entity.ReqFulFillerData;
import com.hackathon.saarathi.springboot.entity.User;
import com.hackathon.saarathi.springboot.mapper.OrderRowMapper;
import com.hackathon.saarathi.springboot.mapper.UserRowMapper;

public class OrderDaoImpl implements OrderDao  {

	public OrderDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Order> findAll() {
		return template.query("select * from orders", new OrderRowMapper());
	}
	
	@Override
	public void insertOrder(Order order) {
		final String sql = "insert into orders(item,quantity,fulfiller_Id,req_id) values"
				+ "(:item,:quantity,:fulFillerId,:reqId)";
		 
		    
		System.out.println("insertOrder  "+sql);	
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					
	        		.addValue("item", order.getItem())
					.addValue("quantity", order.getQuantity())
					.addValue("fulfiller_Id", order.getFulFillerId())
					.addValue("req_id", order.getReqId());
				
			template.update(sql,param, holder);
		
	}

	@Override
	public void executeUpdateOrder(Order order) {

		 final String sql = "update orders set item=:item,quantity=:quantity,fulfiller_Id=:fulFillerId,req_id=:reqId,"
		 		+ " where order_Id=:orderId";
		  
			
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("order_Id", order.getOrderId());

		 
		 map.put("item", order.getItem());
			map.put("quantity", order.getQuantity());
			map.put("fulfiller_Id", order.getFulFillerId());
			map.put("req_id", order.getReqId());
		
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}

	@Override
	public void deleteOrder(Order order) {
		final String sql = "delete from orders where order_id=:orderId";
		 

		 Map<String,Object> map = new HashMap<String,Object>();  
		 map.put("order_id", order.getOrderId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  				
	}


}
