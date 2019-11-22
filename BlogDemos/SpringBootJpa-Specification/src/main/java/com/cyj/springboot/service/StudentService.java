package com.cyj.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cyj.springboot.entity.Student;

public interface StudentService {

	public Student queryById(Integer id);

	public List<Student> queryByNameLike(String name);

	public Page<Student> queryAllPage(Student student, Integer page, Integer size);

}
