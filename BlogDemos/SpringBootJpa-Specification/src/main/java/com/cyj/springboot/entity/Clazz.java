package com.cyj.springboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="clazztb")
public class Clazz implements Serializable{
	
	@Id//实体类的主键
	@GeneratedValue//自动增长列
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:班级自动增长主键'  ")
	private Integer clazzId;
	
	@Column(length=10,unique=true)
	private String clazzName;
	@OrderBy
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:班级总人数'  ")
	private Integer clazzNumber;
	@JsonIgnore
	@OneToMany(mappedBy="clazz",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Student> list = new ArrayList<>();
	
	
	
	
	//----------------------------- 以下是构造方法 ------------------------

	
	
	//----------------------------- 以下是Getter和setter方法 -----------------
	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public Integer getClazzNumber() {
		return clazzNumber;
	}

	public void setClazzNumber(Integer clazzNumber) {
		this.clazzNumber = clazzNumber;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	
	//----------------------------- 以下是重写的toString方法 ------------------------

	@Override
	public String toString() {
		return "Clazz [clazzId=" + clazzId + ", clazzName=" + clazzName + ", clazzNumber=" + clazzNumber + "]";
	}
	

	public String showClazz() {
		return "Clazz [clazzId=" + clazzId + ", clazzName=" + clazzName + ", clazzNumber=" + clazzNumber + "]";
	}
	
	public String showClazzAndStudent() {
		return "Clazz [clazzId=" + clazzId + ", clazzName=" + clazzName + ", clazzNumber=" + clazzNumber + ", list="
				+ list + "]";
	}
	
	

}
