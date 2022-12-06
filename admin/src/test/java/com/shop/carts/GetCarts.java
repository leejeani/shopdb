package com.shop.carts;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;

@SpringBootTest
class GetCarts {

	@Autowired
	CartsService service;
	
	@Test
	void contextLoads() {
		CartsDTO carts = null;
		try {
			carts = service.get(100);
			System.out.println(carts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}




