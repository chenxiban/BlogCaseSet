package com.cyj.springboot.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cyj.springboot.dao.StudentRepository;
import com.cyj.springboot.entity.Clazz;
import com.cyj.springboot.entity.Student;
import com.cyj.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student queryById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Student> queryByNameLike(String name) {
		return repository.findByStudentNameLike("%" + name + "%");
	}

	@Override
	public Page<Student> queryAllPage(Student student, Integer page, Integer size) {// 分页
		Sort sort = new Sort(Sort.Direction.ASC, "studentId");
		Pageable pageable = new PageRequest(page, size, sort);
		return repository.findAll(this.getWhereClause(student), pageable);
	}

	/**
	 * 查询条件动态组装 动态生成where语句 匿名内部类形式
	 * 
	 * @param catSearch
	 * @return
	 */
	private Specification<Student> getWhereClause(final Student stu) {
		return new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> queryy, CriteriaBuilder cb) {
				Join<Student, Clazz> join = root.join("clazz", JoinType.INNER);// 学生属性clazz:学生表和班级表内链接
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合

				// 动态查询学生姓名,连表查询
				if (stu.getStudentName() != null && !"".equals(stu.getStudentName())) {
					exList.add(cb.like(root.<String>get("studentName"), "%" + stu.getStudentName() + "%"));
				}
				System.out.println("动态Sql studentClazzName=>" + stu.getStudentClazzName());
				System.out.println(
						"动态Sql getStudentClazzNameIgnoreEmptyClazz=>" + stu.getStudentClazzNameIgnoreEmptyClazz());
				// 动态查询班级名称
				if (stu.getStudentClazzNameIgnoreEmptyClazz() != null
						&& !"".equals(stu.getStudentClazzNameIgnoreEmptyClazz())) {
					Path<String> clazzNameExp = join.<String>get("clazzName");
					Predicate p1 = cb.like(clazzNameExp, "%" + stu.getStudentClazzNameIgnoreEmptyClazz() + "%");
					System.out.println("Predicate p1=>" + p1);
					exList.add(p1);
				}
				return predicate;
			}

		};
	}

}
