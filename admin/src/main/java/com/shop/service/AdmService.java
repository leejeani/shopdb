package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.AdmDTO;
import com.shop.frame.MyService;
import com.shop.mapper.AdmMapper;

@Service
public class AdmService implements MyService<String, AdmDTO>{

	@Autowired
	AdmMapper mapper;
	
	@Override
	public void register(AdmDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(AdmDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public AdmDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<AdmDTO> get() throws Exception {
		return mapper.selectall();
	}

}
