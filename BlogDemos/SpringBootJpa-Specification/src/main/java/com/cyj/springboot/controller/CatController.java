package com.cyj.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Cat;
import com.cyj.springboot.entitysearch.CatSearch;
import com.cyj.springboot.service.CatService;

/**
 * SpringMVC控制器
 * 
 * @Description: 子模块
 * @ClassName: CityRestController.java
 * @author ChenYongJia
 * @Date 2017-10-4 下午8:04:34
 * @Email 867647213@qq.com
 */
@RestController
public class CatController {

	@Autowired
	private CatService service;

	// 默认静态资源目录:http://localhost:8080/springbootjpasimple.sql

	/**
	 * 测试项目环境是否正常 http://localhost:8080/index
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public Cat index() {
		Cat cat = new Cat("张三", "男", 18, "预留参数");
		return cat;
	}

	/**
	 * 新增 http://localhost:8080/insertOne
	 * 
	 * @return
	 */
	@RequestMapping("/insertOne")
	public Cat add() {
		Cat cat = new Cat("张三", "男", 18, "预留参数");
		return service.insert(cat);
	}

	/**
	 * 排序 http://localhost:8080/orderBy
	 * 
	 * @return
	 */
	@RequestMapping("/orderBy")
	public List<Cat> orderBy() {
		return service.queryAllSort("age");
	}

	/**
	 * 条件模糊查询:[JPA关键字形式] http://localhost:8080/nameLike?name=m
	 * http://localhost:8080/nameLike?name=七
	 * 
	 * @return
	 */
	@RequestMapping("/nameLike")
	public List<Cat> nameLike(String name) {
		return service.queryByNameLike(name);
	}

	/**
	 * 条件模糊查询:[HQL形式] http://localhost:8080/queryName?name=m
	 * 
	 * @return
	 */
	@RequestMapping("/queryName")
	public List<Cat> queryName(String name) {
		return service.queryByName(name);
	}

	/**
	 * 条件模糊查询:[原生SQL形式] http://localhost:8080/queryNameSQL?name=m
	 * 
	 * @return
	 */
	@RequestMapping("/queryNameSQL")
	public List<Cat> queryNameSQL(String name) {
		return service.queryByNameSQL(name);
	}

	/**
	 * http://localhost:8080/queryMaxAge
	 * 
	 * @return
	 */
	@RequestMapping("/queryMaxAge")
	public Long queryMaxAge() {
		return service.queryMaxAge();
	}

	/**
	 * 分页查询 http://localhost:8080/queryPage
	 * 
	 * @return
	 */
	@RequestMapping("/queryPage")
	public Object queryPage() {
		Page<Cat> page = null;
		page = service.queryAllPage(1, 3);// 第2页,每页3条;第几页从零开始,每页显示几条.
		System.out.println("queryPage page=>" + page);
		Long total = page.getTotalElements();
		List<Cat> list = page.getContent();
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	/**
	 * 带条件的排序查询 http://localhost:8080/nameLikeorderBy?name=m
	 * 
	 * @return
	 */
	@RequestMapping("/nameLikeorderBy")
	public List<Cat> nameLikeorderBy(String name) {
		return service.queryNameLikeAllSort(name, "age");
	}

	/**
	 * 带条件的分页查询 http://localhost:8080/queryNameLikePage?name=m
	 * 
	 * @return
	 */
	@RequestMapping("/queryNameLikePage")
	public Object queryNameLikePage(String name) {
		Page<Cat> page = null;
		page = service.queryNameLikeAllPage(name, 0, 3);// 第1页,每页3条;第几页从零开始,每页显示几条.
		System.out.println("page=>" + page);
		Long total = page.getTotalElements();
		List<Cat> list = page.getContent();
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	// ----------------------------使用JpaRepository,Specification动态SQL查询------------------

	/**
	 * 动态条件查询 http://localhost:8080/queryDynamic?name=田
	 * http://localhost:8080/queryDynamic?minAge=50&maxAge=100
	 * http://localhost:8080/queryDynamic?minAge=100&maxAge=200&startBirthday=2017-11-20
	 * 00:00:00&endBirthday=2017-11-20 23:59:59
	 * 
	 * @return
	 */
	@RequestMapping("/queryDynamic")
	public List<Cat> queryDynamic(CatSearch search) {
		List<Cat> list = service.queryByDynamicSQL(search);
		System.out.println("动态查询 list=>" + list);
		return list;
	}

}
