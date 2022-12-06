package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.CustDTO;
import com.shop.service.CustService;

@Controller
@RequestMapping("/cust")
public class CustController {

	String dir = "cust/";
	
	@Autowired
	CustService service;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center",dir+"register");
		return "index";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, CustDTO cust) throws Exception {
		try {
			service.register(cust);
		} catch (Exception e) {
			throw new Exception("ID중복에러");
		}
		return "redirect:get";
	}
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<CustDTO> list = null;
		try {
			list = service.get();
			model.addAttribute("clist",list);
			model.addAttribute("center",dir+"get");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = service.get(id);
			model.addAttribute("c",cust);
			model.addAttribute("center",dir+"detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(Model model, CustDTO cust) {
		try {
			service.modify(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id="+cust.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, String id) {
		try {
			service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:get";
	}
}






