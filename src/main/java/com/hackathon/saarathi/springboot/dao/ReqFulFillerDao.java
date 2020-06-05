package com.hackathon.saarathi.springboot.dao;

import java.util.List;


import com.hackathon.saarathi.springboot.entity.ReqFulFillerData;


public interface ReqFulFillerDao {

	public List<ReqFulFillerData> findAll();

	public void insertReqFulFillerData(ReqFulFillerData reqFulFillerData);

	public void deleteReqFulFillerData(ReqFulFillerData reqFulFillerData);

	void updateReqFulFillerData(ReqFulFillerData reqFulFillerData);

}
