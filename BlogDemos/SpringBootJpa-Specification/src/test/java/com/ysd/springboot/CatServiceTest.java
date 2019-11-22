package com.ysd.springboot;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.springboot.entity.Cat;
import com.ysd.springboot.entitysearch.CatSearch;
import com.ysd.springboot.service.CatService;

/**
 * Spring Test FrameWork	Spring测试框架使用示例
 * @Description:   测试Service层功能
 * @ClassName:     CatServiceTest.java 
 * @author         Mashuai 
 * @Date           2017-10-4 下午8:04:34  
 * @Email          1119616605@qq.com
 */

@RunWith(SpringRunner.class)	//Spring集成Junit单元测试
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)	//提供Spring Web 测试环境, 并在测试中支持自动注入 injected field on the test
@EnableAutoConfiguration	//启用Spring应用程序上下文的自动配置
public class CatServiceTest {
	
	@Autowired
	private CatService service;
	
	
	@Test
	public void exist(){
		Boolean boo = service.exists(1);//判断id=1的Cat对象是否已存在
		Assert.assertTrue(boo);//断言是true
	}
	
	@Test
	public void queryMaxAge(){
		long maxAge = service.queryMaxAge();
		System.out.println("queryMaxAge maxAge=>"+maxAge);
		Assert.assertNotEquals(maxAge, 0L);
	}
	
	@Test
	public void queryPage() {
    	Page<Cat> page = null;
    	page = service.queryAllPage(1, 3);//第2页,每页3条;第几页从零开始,每页显示几条.
    	System.out.println("queryPage page=>"+page);
    	Long total = page.getTotalElements();
    	List<Cat> list = page.getContent();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	System.out.println("queryPage EasyUI =>"+map);
    	Assert.assertNotEquals(page, null);
	 }
	
	
	
	
	
	//----------------------------使用JpaRepository,Specification动态SQL查询------------------
	
	
	
	@Test
	public void queryByDynamicSQL(){
		CatSearch catSearch = new CatSearch("三");
		List<Cat> list = service.queryByDynamicSQL(catSearch);
		System.out.println("姓名 list=>"+list);
		catSearch = new CatSearch(0,16);
		list = service.queryByDynamicSQL(catSearch);
		System.out.println("年龄 list=>"+list);
		catSearch = new CatSearch(str2Date("2017-11-20 00:00:00"),str2Date("2017-11-20 23:59:59"));
		list = service.queryByDynamicSQL(catSearch);
		System.out.println("出生日期 list=>"+list);
		
	}
	
	@Test
	public void queryByDynamicSQL02(){
		CatSearch catSearch = new CatSearch("三");
		List<Cat> list = service.queryByDynamicSQL02(catSearch);
		System.out.println("姓名 list02=>"+list);
		catSearch = new CatSearch(0,16);
		list = service.queryByDynamicSQL02(catSearch);
		System.out.println("年龄 list02=>"+list);
		catSearch = new CatSearch(str2Date("2017-11-20 00:00:00"),str2Date("2017-11-20 23:59:59"));
		list = service.queryByDynamicSQL02(catSearch);
		System.out.println("出生日期 list02=>"+list);
		
	}
	
	
	
	
	/**
	 * 字符串转日期
	 * @param dateStr
	 * @return
	 */
	public Date str2Date(String dateStr){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	
	
	

}
