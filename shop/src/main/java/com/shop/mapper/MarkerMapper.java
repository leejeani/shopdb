package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.MarkerDTO;
import com.shop.frame.MyMapper;
@Repository
@Mapper
public interface MarkerMapper extends MyMapper<Integer, MarkerDTO>{
	List<MarkerDTO> getloc(String loc) throws Exception; 
}
