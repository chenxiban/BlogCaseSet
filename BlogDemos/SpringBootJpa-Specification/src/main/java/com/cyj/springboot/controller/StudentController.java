package com.cyj.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyj.springboot.entity.Student;
import com.cyj.springboot.service.StudentService;

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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	/**
	 * http://localhost:8080/student/queryById?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryById")
	public Student queryById(Integer id) {
		Student student = service.queryById(id);
		System.out.println("queryById student=>" + student.showStudentAndClazz());
		return student;
	}

	/**
	 * http://localhost:8080/student/queryId?id=1
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryId")
	public String queryId(Integer id) {
		Student student = service.queryById(id);
		System.out.println("queryById student=>" + student.showStudentAndClazz());
		return "查询成功";
	}

	/**
	 * http://localhost:8080/student/queryByNameLike?name=张三
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryByNameLike")
	public Object queryByNameLike(String name) {
		List<Student> list = service.queryByNameLike(name);
		System.out.println("queryByNameLike list=>" + list);
		for (Student s : list) {
			System.out.println("Student =>" + s.showStudentAndClazz());
		}
		return list;
	}

	/**
	 * http://localhost:8080/student/queryAllPage
	 * http://localhost:8080/student/queryAllPage?studentName=张三&clazzName=1501
	 * http://localhost:8080/student/queryAllPage?clazzName=1501
	 * 
	 * @param id
	 * @return Student
	 */
	@RequestMapping("/queryAllPage")
	public Object queryAllPage(String studentName, String clazzName) {
		System.out.println("studentName=>" + studentName);
		System.out.println("clazzName=>" + clazzName);
		Student stu = new Student();
		stu.setStudentName(studentName);
		stu.setStudentClazzName(clazzName);

		Page<Student> page = null;
		page = service.queryAllPage(stu, 0, 10);// 第1页,每页10条;第几页从零开始(第1页则是0),每页显示几条.
		System.out.println("page=>" + page);
		Long total = page.getTotalElements();
		List<Student> list = page.getContent();
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

}
