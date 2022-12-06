package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.ItemDTO;
import com.shop.frame.Util;
import com.shop.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	String dir = "item/";
	
	@Value("${admindir}")
	String admindir;
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	ItemService service;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, ItemDTO obj) {

		String imgname = obj.getImg().getOriginalFilename();
		obj.setImgname(imgname);
		
		try {
			Util.saveFile(obj.getImg(), admindir, custdir);
			service.register(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:get";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, int id) {
		ItemDTO obj = null;
		try {
			obj = service.get(id);
			model.addAttribute("obj",obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center",dir+"detail");
		return "index";
	}
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<ItemDTO> list = null;
		try {
			list = service.get();
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center",dir+"get");
		return "index";
	}
}








