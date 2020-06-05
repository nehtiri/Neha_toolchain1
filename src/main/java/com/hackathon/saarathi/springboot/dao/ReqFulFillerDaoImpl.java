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
import org.springframework.stereotype.Repository;

import com.hackathon.saarathi.springboot.entity.ReqFulFillerData;
import com.hackathon.saarathi.springboot.entity.User;
import com.hackathon.saarathi.springboot.mapper.ReqFulFillerRowMapper;
import com.hackathon.saarathi.springboot.mapper.UserRowMapper;

@Repository
public class ReqFulFillerDaoImpl implements ReqFulFillerDao {

	NamedParameterJdbcTemplate template;  


	public ReqFulFillerDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}  

	@Override
	public List<ReqFulFillerData> findAll() {
		return template.query("select * from requester_fulfiller", new ReqFulFillerRowMapper());
	}

	@Override
	public void insertReqFulFillerData(ReqFulFillerData reqFulFillerData) {

		 final String sql = "insert into requester_fulfiller(pan_TAN,aadhar_Card_no,bank_AccountNo,iFSC,skills,specification,area,phoneNumber) values(:panTAN,:aadharCardNo,:bankAccountNo,:iFSC,:skills,:specification,:area,:phoneNumber)";
		 
		 
			System.out.println("insertReqFulFillerData  "+sql);	
		        KeyHolder holder = new GeneratedKeyHolder();
		        SqlParameterSource param = new MapSqlParameterSource()
						
		        		.addValue("pan_TAN", reqFulFillerData.getPanTAN())
						.addValue("aadhar_Card_no", reqFulFillerData.getAadharCardNo())
						.addValue("bank_AccountNo", reqFulFillerData.getBankAccountNo())
						.addValue("iFSC", reqFulFillerData.getIFSC())
						.addValue("skills", reqFulFillerData.getSkills())
				.addValue("specification", reqFulFillerData.getSpecification())
		    	.addValue("area", reqFulFillerData.getArea())
				.addValue("phoneNumber", reqFulFillerData.getPhoneNumber());

				template.update(sql,param, holder);

		 		
	}

	@Override
	public void updateReqFulFillerData(ReqFulFillerData reqFulFillerData) {
		 	
		final String sql = "update requester_fulfiller set pan_TAN=:panTAN,aadhar_Card_no=:aadharCardNo,bank_AccountNo=:bankAccountNo,iFSC=:iFSC,skills=:skills,specification=:specification,area=:area,phoneNumber=:phoneNumber" + 
				" where id=:id";

		System.out.println("updateReqFulFillerData  " + sql);
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()

				.addValue("pan_TAN", reqFulFillerData.getPanTAN())
				.addValue("aadhar_Card_no", reqFulFillerData.getAadharCardNo())
				.addValue("bank_AccountNo", reqFulFillerData.getBankAccountNo())
				.addValue("iFSC", reqFulFillerData.getIFSC()).addValue("skills", reqFulFillerData.getSkills())
				.addValue("specification", reqFulFillerData.getSpecification())
				.addValue("area", reqFulFillerData.getArea())
				.addValue("phoneNumber", reqFulFillerData.getPhoneNumber());

		template.update(sql, param, holder);

	}

	@Override
	public void deleteReqFulFillerData(ReqFulFillerData reqFulFillerData) {
		final String sql = "delete from requester_fulfiller where id=:id";
		 

		 Map<String,Object> map = new HashMap<String,Object>();  
		 map.put("id", reqFulFillerData.getId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  		
	}

}
