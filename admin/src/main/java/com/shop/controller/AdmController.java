package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.AdmDTO;
import com.shop.service.AdmService;

@Controller
@RequestMapping("/adm")
public class AdmController {

	String dir = "adm/";
	
	@Autowired
	AdmService service;
	
	@RequestMapping("/get")
	public String main(Model model) {
		List<AdmDTO> list = null;
		try {
			list = service.get();
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center",dir+"get");
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model model, String id) {
		AdmDTO adm = null;
		try {
			adm = service.get(id);
			model.addAttribute("obj",adm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center",dir+"detail");
		return "index";
	}
	
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, AdmDTO obj) throws Exception {
		try {
			service.register(obj);
		} catch (Exception e) {
			throw new Exception("ID 중복 에러");
		}
		return "redirect:detail?id="+obj.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, String id) throws Exception {
		try {
			service.remove(id);
		} catch (Exception e) {
			throw new Exception("ID 중복 에러");
		}
		return "redirect:get";
	}
	
	@RequestMapping("/update")
	public String update(Model model, AdmDTO admin) {
		try {
			service.modify(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id="+admin.getId();
	}
}
















