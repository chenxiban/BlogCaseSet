package com.cyj.springboot.service;

import java.util.List;

import com.cyj.springboot.entity.City;

public interface CityService {

	public List<City> queryCityByName(String name);

}
