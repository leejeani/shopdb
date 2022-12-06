package com.shop.ajax;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.AdmDTO;
import com.shop.dto.CustDTO;
import com.shop.mapper.AJAXMapper;
import com.shop.service.AdmService;

@SpringBootTest
class CustCnt {

	@Autowired
	AJAXMapper mapper;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		try {
			cnt = mapper.getCustCnt();
			System.out.println(cnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}




