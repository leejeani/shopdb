package com.shop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartsDTO {
	private int id;
	private String cust_id;
	private int item_id;
	private int cnt;
	private Date rdate;
	
	private String cust_name;
	private String item_name;
	private int item_price;
	private String item_imgname;
}












