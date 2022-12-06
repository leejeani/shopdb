package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CartsDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface CartsMapper extends MyMapper<Integer, CartsDTO>{
	public List<CartsDTO> cartsall(String cust_id) throws Exception;
}
