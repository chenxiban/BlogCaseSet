package com.cyj.springboot.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyj.springboot.entity.City;
import com.cyj.springboot.mapper.CityMapper;
import com.cyj.springboot.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper mapper;

	@Override
	public List<City> queryCityByName(String name) {
		return mapper.queryCityByName(name);
	}

}
