package com.cyj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyj.springboot.entity.City;

public interface CityMapper {

	public List<City> queryCityByName(@Param("name") String name);

}
