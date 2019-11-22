package com.cyj.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // HQL 使用,默认类名
@Table(name = "cattb") // 数据库原生SQL使用,默认表名
public class Cat implements Serializable {

	// Cat实体的属性: id, name, sex, age, birthday, updateTime

	@Id // 实体类的主键
	@GeneratedValue // 自动增长列
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:猫自动增长主键'  ")
	private Integer id;
	@Column(length = 20) // 字符长度20
	private String name;
	@Column(columnDefinition = "char(1) comment '备注:猫姓名' ")
	private String sex;
	@Column(columnDefinition = "int unsigned DEFAULT 0 comment '备注:猫年龄'  ")
	private Integer age;

	private Date birthday;
//	@CreationTimestamp@UpdateTimestamp	//插入,修改时自动维护时间戳
	@Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Timestamp updateTime;
	@Transient // 临时参数,不映射到数据库表字段
	private String catParam;

	// ----------------------------- 以下是构造方法 ------------------------

	public Cat(String name, String sex, Integer age, String catParam) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = new Date();
		this.catParam = catParam;
	}

	public Cat(String name, String sex, Integer age, Date birthday, String catParam) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.catParam = catParam;
	}

	public Cat() {
		super();
	}

	// ----------------------------- 以下是Getter和setter方法 ------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCatParam() {
		return catParam;
	}

	public void setCatParam(String catParam) {
		this.catParam = catParam;
	}

	// ----------------------------- 以下是重写的toString方法 ------------------------

	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", birthday=" + birthday
				+ ", updateTime=" + updateTime + ", catParam=" + catParam + "]";
	}

}
