package com.hackathon.saarathi.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class ReqFulFillerData {

	  Long id;
	  Long panTAN;
	  Long aadharCardNo;
	  Long  bankAccountNo;
	  String   iFSC;
	  String  skills;
	  String  specification;
	  String  area;
	  Long phoneNumber;
}
