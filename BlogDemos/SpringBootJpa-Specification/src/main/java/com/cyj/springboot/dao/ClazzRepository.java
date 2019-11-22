package com.cyj.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyj.springboot.entity.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer>{
	
	//Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);  
    public List<Clazz> findByClazzNameLike(String name);

}
