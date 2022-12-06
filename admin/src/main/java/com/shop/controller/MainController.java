package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.AdmDTO;
import com.shop.dto.ItemDTO;
import com.shop.frame.OCRUtil;
import com.shop.frame.Util;
import com.shop.mapper.ItemMapper;
import com.shop.service.AdmService;

@Controller
public class MainController {

	@Autowired
	AdmService service;
	
	@Autowired
	ItemMapper mapper;
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;
	
	
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/ocrtest")
	public String ocrtest(Model model) {
		model.addAttribute("center", "ocr");
		return "index";
	}
	
	@RequestMapping("/websocket")
	public String websocket(Model model) {
		model.addAttribute("center", "websocket");
		return "index";
	}

	@RequestMapping("/ocrimpl")
	public String ocrimpl(Model model, ItemDTO obj) {

		String imgname = obj.getImg().getOriginalFilename();
		obj.setImgname(imgname);
		
		try {
			Util.saveFile(obj.getImg(), admindir, custdir);
			String result = OCRUtil.getText(imgname);
			System.out.println(result);
			
			JSONParser jsonparser = new JSONParser();
			JSONObject jo = (JSONObject)jsonparser.parse(result);
			//System.out.println(jo.toString());
			JSONArray ja1 =  (JSONArray) jo.get("images");
			JSONObject jo1 = (JSONObject) ja1.get(0);
			JSONArray ja2 = (JSONArray) jo1.get("fields");
			
			
			JSONObject f1 = (JSONObject) ja2.get(0);
			JSONObject f2 = (JSONObject) ja2.get(1);
			JSONObject f3 = (JSONObject) ja2.get(2);
			
			String name1 = (String) f1.get("inferText");
			String name2 = (String) f2.get("inferText");
			String no = (String) f3.get("inferText");
			
			model.addAttribute("name1", name1);
			model.addAttribute("name2", name2);
			model.addAttribute("no", no);
			
			model.addAttribute("center", "ocrresult");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/searchimpl")
	public String searchimpl(Model model, String txt) {
		List<ItemDTO> list = null;
		try {
			list = mapper.searchitem(txt);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "search");
		return "index";
	}
	
	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String id, String pwd) {
		AdmDTO adm = null;
		try {
			adm = service.get(id);
			if(adm != null) {
				if(adm.getPwd().equals(pwd)) {
					session.setAttribute("loginadmin", adm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}









