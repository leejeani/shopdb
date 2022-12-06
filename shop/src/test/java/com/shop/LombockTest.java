package com.shop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustDTO;

@SpringBootTest
class LombockTest {

	@Test
	void contextLoads() {
		CustDTO c = new CustDTO("id01", "pwd01", "Lee");
		System.out.println(c);
	}

}
