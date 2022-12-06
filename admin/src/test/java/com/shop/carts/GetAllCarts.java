package com.shop.carts;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;

@SpringBootTest
class GetAllCarts {

	@Autowired
	CartsService service;
	
	@Test
	void contextLoads() {
		List<CartsDTO> list = null;
		try {
			list = service.cartsall("id01");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(CartsDTO c:list) {
			System.out.println(c);
		}
		
	}

}




