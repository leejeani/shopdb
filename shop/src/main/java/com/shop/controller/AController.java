package com.shop.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.MarkerDTO;
import com.shop.service.MarkerService;
import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;
import com.shop.service.CustService;

@RestController
public class AController {
	
	@Autowired
	CustService cust_service;

	@Autowired
	CartsService carts_service;
	
	@Autowired
	MarkerService marker_service;
	
	@RequestMapping("/addcart")
	public Object addcart(CartsDTO cart) {
		try {
			carts_service.register(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	
	@RequestMapping("/getmarker2")
	public Object getmarker2(String loc) {
		JSONArray ja = new JSONArray();
		if(loc.equals("s")) {
			JSONObject jo1 = new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 37.5286891);
			jo1.put("lng", 127.061432);
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 37.5386891);
			jo2.put("lng", 127.021432);
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 37.5186891);
			jo3.put("lng", 127.031432);
			ja.add(jo3);
		}else if(loc.equals("b")) {
            //35.1223984,129.0896448
			JSONObject jo1 = new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 35.1233984);
			jo1.put("lng", 129.0906448);
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 35.1243984);
			jo2.put("lng", 129.0936448);
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 35.1253984);
			jo3.put("lng", 129.0966448);
			ja.add(jo3);
		}else if(loc.equals("j")) {
			//33.5199183,126.6142571
			JSONObject jo1 = new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 33.5239183);
			jo1.put("lng", 126.6162571);
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 33.5119183);
			jo2.put("lng", 126.6252571);
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 33.5109183);
			jo3.put("lng", 126.6242571);
			ja.add(jo3);
		}
		
		
		return ja;
	}
	
	
	@RequestMapping("/getmarker")
	public Object getmarker(String loc) {
		JSONArray ja = new JSONArray();
		
		List<MarkerDTO> list = null;
		try {
			list = marker_service.getloc(loc);
			for(MarkerDTO m:list) {
				JSONObject jo = new JSONObject();
				jo.put("title", m.getTitle());
				jo.put("target", m.getTarget());
				jo.put("lat", m.getLat());
				jo.put("lng", m.getLng());
				jo.put("loc", m.getLoc());
				jo.put("img", m.getImg());
				ja.add(jo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ja;
	}
	
	@RequestMapping("/gettime")
	public Object gettime() {
		Date d = new Date();
		return "Server Time:"+d.toString();
	}
	
	
	@RequestMapping("/ch3")
	public Object ch3(String area) {
		// {title:'Seoul',data:[[],[]]}
		JSONObject jo = new JSONObject();
		if(area.equals("s")) {
			jo.put("title", "Seoul");
			JSONArray ja = new JSONArray();
			for(var i=1 ;i<=5;i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			jo.put("data", ja);
		}else if(area.equals("b")){
			jo.put("title", "Busan");
			JSONArray ja = new JSONArray();
			for(var i=1 ;i<=5;i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			jo.put("data", ja);
		}else if(area.equals("j")) {
			jo.put("title", "Jeju");
			JSONArray ja = new JSONArray();
			for(var i=1 ;i<=5;i++) {
				JSONArray jaa = new JSONArray();
				jaa.add((i*10)+"대");
				jaa.add(20);
				ja.add(jaa);
			}
			jo.put("data", ja);
		}
		return jo;
	}
	
	@RequestMapping("/getdata1")
	public Object getdata1() {
		// [{name:'',data:[]},{}]
		Random r = new Random();
		String str = "seoul";
		JSONArray ja = new JSONArray();
		for(var i=1; i<=5; i++) {
			JSONObject jo = new JSONObject();
			jo.put("name", str+i);
			JSONArray jaa = new JSONArray();
			for(var j=1;j<=12;j++) {
				jaa.add(r.nextInt(10000)+1);
			}
			jo.put("data",jaa);
			ja.add(jo);
		}
		return ja;
	}
	
	@RequestMapping("/getdata2")
	public Object getdata2() {
		// [[],[],[]]
		Random r = new Random();
		JSONArray ja = new JSONArray();
		
		String str = "Korea";
		
		for(var i=1;i<=20;i++) {
			JSONArray jaa = new JSONArray();
			jaa.add(str+i);
			jaa.add(r.nextInt(100)+1);
			ja.add(jaa);
		}
		
		return ja;
	}
	
	@RequestMapping("/ch1")
	public Object ch1() {
		Random r = new Random();
		JSONArray ja_data = new JSONArray();
		for(var i=1; i<=10;i++) {
			ja_data.add(r.nextInt(30000)+1);
		}
		JSONArray ja_cate = new JSONArray();
		ja_cate.add("한국");
		ja_cate.add("일본");
		ja_cate.add("중국");
		ja_cate.add("미국");
		ja_cate.add("싱가폴");
		ja_cate.add("미얀마");
		ja_cate.add("미국");
		ja_cate.add("호주");
		ja_cate.add("태국");
		ja_cate.add("캄보디아");
		
		JSONObject jo = new JSONObject();
		jo.put("cate", ja_cate);
		jo.put("data", ja_data);
		return jo;
	}
	
	@RequestMapping("/getdata")
	public Object getdata() {
		Random r = new Random();
		JSONArray ja = new JSONArray();
		JSONObject jo1 = new JSONObject();
		int i1 = r.nextInt(10)+1;
		jo1.put("num", i1);
		jo1.put("title", "오징어나라");
		jo1.put("updown","up");
		JSONObject jo2 = new JSONObject();
		int i2 = r.nextInt(20)+1;
		jo2.put("num", i2);
		jo2.put("title", "태풍");
		jo2.put("updown","down");
		JSONObject jo3 = new JSONObject();
		int i3 = r.nextInt(20)+1;
		jo3.put("num", i3);
		jo3.put("title", "러시아");
		jo3.put("updown","up");
		JSONObject jo4 = new JSONObject();
		int i4 = r.nextInt(20)+1;
		jo4.put("num", i4);
		jo4.put("title", "공작2");
		jo4.put("updown","up");
		JSONObject jo5 = new JSONObject();
		int i5 = r.nextInt(20)+1;
		jo5.put("num", i5);
		jo5.put("title", "미국");
		jo5.put("updown","down");
		ja.add(jo1);
		ja.add(jo2);
		ja.add(jo3);
		ja.add(jo4);
		ja.add(jo5);
		
		return ja;
	}
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		CustDTO cust = null;
		try {
			cust = cust_service.get(cid);
			if(cust != null) {
				result = "f";
			}else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}











