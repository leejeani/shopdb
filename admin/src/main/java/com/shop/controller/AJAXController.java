package com.shop.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ChartDTO;
import com.shop.frame.WUtil;
import com.shop.mapper.AJAXMapper;

@RestController
public class AJAXController {

	@Autowired
	AJAXMapper mapper;
	
	@RequestMapping("/weather")
	public Object weather(String loc) throws IOException {
		return WUtil.getData(loc);
	}
	
	
	@RequestMapping("/custcnt")
	public String custcnt() {
		int cnt = mapper.getCustCnt();
		return cnt+"";
	}
	@RequestMapping("/chart2")
	public Object chart2(String ssm, String eem) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sm", ssm);
		map.put("em", eem);
		List<ChartDTO> list = null;
		list = mapper.chart2(map);
		// [{name:'',y:''},{}]
		JSONArray ja = new JSONArray();
		for(ChartDTO c:list) {
			JSONObject jo = new JSONObject();
			jo.put("name", c.getGender());
			jo.put("y", c.getTotal_price());
			ja.add(jo);
		}
		return ja;
	}
	
	@RequestMapping("/chart1")
	public Object chart1() {
		JSONObject result = new JSONObject();
		
		
		JSONArray ja = new JSONArray();
		JSONObject mobj = new JSONObject();
		JSONObject fobj = new JSONObject();
		mobj.put("name", "Male");
		fobj.put("name", "Female");
		
		JSONArray mja = new JSONArray();
		JSONArray fja = new JSONArray();
		
		List<ChartDTO> list = null;
		
		list = mapper.chart1();
		
		JSONArray month_ja = new JSONArray();
		int m = 0;
		for(ChartDTO c:list) {
			if(c.getGender().equals("M")) {
				mja.add(c.getTotal_price());
			}else{
				fja.add(c.getTotal_price());
				m++;
				month_ja.add(m);
			}
		}
		mobj.put("data", mja);
		fobj.put("data", fja);
		ja.add(mobj);
		ja.add(fobj);
		
		// [{},{}]
		// {"month":[1,2,3,4,5,6],"result":[{},{}]}
		result.put("month", month_ja);
		result.put("result", ja);
		return result;
	}
	
}









