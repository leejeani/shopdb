package com.shop.item;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.ItemDTO;
import com.shop.service.ItemService;

@SpringBootTest
class GetItem {

	@Autowired
	ItemService service;
	
	@Test
	void contextLoads() {
		ItemDTO item = null;
		try {
			item = service.get(104);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(item);
		
		
	}

}




