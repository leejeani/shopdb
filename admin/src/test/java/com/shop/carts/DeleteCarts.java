package com.shop.carts;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;

@SpringBootTest
class DeleteCarts {

	@Autowired
	CartsService service;
	
	@Test
	void contextLoads() {
		try {
			service.register(new CartsDTO(0, "id01", 101, 3, null, null, null, 0, null));
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




