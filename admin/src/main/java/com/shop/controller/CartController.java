package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.CartsDTO;
import com.shop.service.CartsService;

@Controller
@RequestMapping("/cart")
public class CartController {

	String dir = "cart/";
	
	@Autowired
	CartsService service;
	
	@RequestMapping("")
	public String main(Model model) {
		List<CartsDTO> list = null;
		try {
			list = service.get();
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center",dir+"get");
		return "index";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int id) {
		try {
			service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:";
	}
}










