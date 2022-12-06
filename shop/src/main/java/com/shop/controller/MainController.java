package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.CartsService;
import com.shop.service.CustService;
import com.shop.service.ItemService;


@Controller
public class MainController {

	@Autowired
	CustService cust_service;
	
	@Autowired
	ItemService item_service;
	
	@Autowired
	CartsService carts_service;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/itemdetail")
	public String itemdetail(Model model, int id) {
		ItemDTO item = null;
		try {
			item = item_service.get(id);
			model.addAttribute("itemdetail",item);
			model.addAttribute("center", "itemdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("left", "shopleft");
		model.addAttribute("center", "shopcenter");
		
		return "main";
	}
	
	@RequestMapping("/item")
	public String item(Model model) {
		List<ItemDTO> list = null;
		try {
			list = item_service.get();
			model.addAttribute("itemlist",list);
			model.addAttribute("center", "item");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/cart")
	public String cart(Model model, String id) {
		List<CartsDTO> list = null;
		try {
			list = carts_service.cartsall(id);
			model.addAttribute("mycarts",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", "cart");
		return "main";
	}
	
	@RequestMapping("/deletecart")
	public String deletecart(Model model, int id, String cust_id) {
		try {
			carts_service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cart?id="+cust_id;
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		return "main";
	}
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", "register");
		return "main";
	}
	
	@RequestMapping("/websocket")
	public String websocket(Model model) {
		model.addAttribute("center", "websocket");
		return "main";
	}
	@RequestMapping("/chatbot")
	public String chatbot(Model model) {
		model.addAttribute("center", "chatbot");
		return "main";
	}
	@RequestMapping("/custdetail")
	public String custdetail(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = cust_service.get(id);
			model.addAttribute("custdetail",cust);
			model.addAttribute("center", "custdetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/custupdateimpl")
	public String custupdateimpl(Model model, CustDTO cust) {
		// 수정 한 이후에 custdetail 페이지로 이동
		try {
			cust_service.modify(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:custdetail?id="+cust.getId();
	}
	@RequestMapping("/custupdate")
	public String custupdate(Model model, String id) {
		CustDTO cust = null;
		try {
			cust = cust_service.get(id);
			model.addAttribute("custupdate",cust);
			model.addAttribute("center", "custupdate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "main";
	}
	
	
	
	@RequestMapping("/loginimpl")
	public String loginimpl(String id, String pwd, Model model,
			HttpSession session) {
		CustDTO cust = null;
		try {
			cust = cust_service.get(id);
			if(cust == null) {
				model.addAttribute("center", "loginfail");
			}else {
				if(pwd.equals(cust.getPwd())) {
					session.setAttribute("logincust", cust);
					model.addAttribute("center", "loginok");
				}else {
					model.addAttribute("center", "loginfail");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/registerimpl")
	public String registerimpl(Model model, CustDTO cust, HttpSession session) {
		try {
			cust_service.register(cust);
			session.setAttribute("logincust", cust);
			model.addAttribute("center", "registerok");
			model.addAttribute("rid", cust);
		} catch (Exception e) {
			model.addAttribute("center", "registerfail");
			model.addAttribute("fid", cust.getId());
		}
		return "main";
	}
}













