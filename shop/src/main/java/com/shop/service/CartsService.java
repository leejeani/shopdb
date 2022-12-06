package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CartsDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CartsMapper;

@Service
public class CartsService implements MyService<Integer, CartsDTO>{

	@Autowired
	CartsMapper mapper;
	
	@Override
	public void register(CartsDTO v) throws Exception {
		mapper.insert(v);		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(CartsDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CartsDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CartsDTO> get() throws Exception {
		return null;
	}

	public List<CartsDTO> cartsall(String cust_id) throws Exception {
		return mapper.cartsall(cust_id);
	}
}









