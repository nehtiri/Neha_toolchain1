package com.hackathon.saarathi.springboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hackathon.saarathi.springboot.entity.ReqFulFillerData;
import com.hackathon.saarathi.springboot.entity.User;

public class ReqFulFillerRowMapper implements RowMapper<ReqFulFillerData>{

	@Override
	public ReqFulFillerData mapRow(ResultSet rs, int arg1) throws SQLException {
		
		
		ReqFulFillerData reqFulFillerData = new ReqFulFillerData();
	
		reqFulFillerData.setId(rs.getLong("id"));	
		reqFulFillerData.setPanTAN(rs.getLong("pan_TAN"));
		reqFulFillerData.setAadharCardNo(rs.getLong("aadhar_Card_no"));
		reqFulFillerData.setBankAccountNo(rs.getLong("bank_AccountNo"));
		reqFulFillerData.setIFSC(rs.getString("iFSC"));

		reqFulFillerData.setSkills(rs.getString("skills"));
		reqFulFillerData.setSpecification(rs.getString("specification"));
		reqFulFillerData.setArea(rs.getString("area"));
		reqFulFillerData.setPhoneNumber(rs.getLong("phoneNumber"));
	  
		return reqFulFillerData;
	}
}
