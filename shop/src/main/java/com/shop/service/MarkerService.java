package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.MarkerDTO;
import com.shop.frame.MyService;
import com.shop.mapper.MarkerMapper;

@Service
public class MarkerService implements MyService<Integer, MarkerDTO>{

	@Autowired
	MarkerMapper mapper;
	
	@Override
	public void register(MarkerDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MarkerDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MarkerDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MarkerDTO> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<MarkerDTO> getloc(String loc) throws Exception{
		return mapper.getloc(loc);
	}

}











