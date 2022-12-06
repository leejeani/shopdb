package com.shop.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.ItemDTO;
import com.shop.service.ItemService;

@SpringBootTest
class DeleteItem {

	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(104);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




