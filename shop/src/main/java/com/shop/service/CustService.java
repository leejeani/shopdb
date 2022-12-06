package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CustDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CustMapper;

@Service
public class CustService implements MyService<String, CustDTO>{

	@Autowired
	CustMapper mapper;
	
	@Override
	public void register(CustDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(CustDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CustDTO get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CustDTO> get() throws Exception {
		return mapper.selectall();
	}

}
