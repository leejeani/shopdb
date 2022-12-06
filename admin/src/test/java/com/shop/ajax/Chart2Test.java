package com.shop.ajax;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.ChartDTO;
import com.shop.mapper.AJAXMapper;

@SpringBootTest
class Chart2Test {

	@Autowired
	AJAXMapper mapper;
	
	@Test
	void contextLoads() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sm", "1");
		map.put("em", "8");
		List<ChartDTO> list = null;
		list = mapper.chart2(map);
		for(ChartDTO c : list) {
			System.out.println(c);
		}
	}

}




