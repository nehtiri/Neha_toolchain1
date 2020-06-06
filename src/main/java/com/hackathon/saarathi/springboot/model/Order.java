package com.hackathon.saarathi.springboot.model;

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
