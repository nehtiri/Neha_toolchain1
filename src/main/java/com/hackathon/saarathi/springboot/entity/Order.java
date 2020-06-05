package com.hackathon.saarathi.springboot.entity;

import lombok.Data;

@Data
//@AllArgsConstructor
public class Order {

	 Long orderId;
	 String item;
	 Long quantity;
	 Long  fulFillerId;
	 Long  reqId;
}
