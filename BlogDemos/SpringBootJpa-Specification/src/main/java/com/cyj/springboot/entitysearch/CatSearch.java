package com.cyj.springboot.entitysearch;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @Description: 查询条件实体类
 * @ClassName: CatSearch.java
 * @author ChenYongJia
 * @Date 2017年11月18日 下午11:49:24
 * @Email 867647213@qq.com
 */
public class CatSearch {

	// Cat实体的属性: id, name, sex, age, birthday, updateTime
	// CatSearch实体的属性: name, sex, minAge, maxAge, startBirthday, endBirthday,
	// startUpdateTime, endUpdateTime

	private String name;
	private String sex;
	private Integer minAge;
	private Integer maxAge;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startBirthday;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endBirthday;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startUpdateTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endUpdateTime;

	// ----------------------------- 以下是构造方法 ------------------------

	public CatSearch() {
		super();
	}

	public CatSearch(String name, String sex, Integer minAge, Integer maxAge, Date startBirthday, Date endBirthday,
			Date startUpdateTime, Date endUpdateTime) {
		super();
		this.name = name;
		this.sex = sex;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.startBirthday = startBirthday;
		this.endBirthday = endBirthday;
		this.startUpdateTime = startUpdateTime;
		this.endUpdateTime = endUpdateTime;
	}

	public CatSearch(Date startBirthday, Date endBirthday) {
		super();
		this.startBirthday = startBirthday;
		this.endBirthday = endBirthday;
	}

	public CatSearch(Integer minAge, Integer maxAge) {
		super();
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	public CatSearch(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public CatSearch(String name) {
		super();
		this.name = name;
	}

	// ----------------------------- 以下是Getter和setter方法 ------------------------
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

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Date getStartBirthday() {
		return startBirthday;
	}

	public void setStartBirthday(Date startBirthday) {
		this.startBirthday = startBirthday;
	}

	public Date getEndBirthday() {
		return endBirthday;
	}

	public void setEndBirthday(Date endBirthday) {
		this.endBirthday = endBirthday;
	}

	public Date getStartUpdateTime() {
		return startUpdateTime;
	}

	public void setStartUpdateTime(Date startUpdateTime) {
		this.startUpdateTime = startUpdateTime;
	}

	public Date getEndUpdateTime() {
		return endUpdateTime;
	}

	public void setEndUpdateTime(Date endUpdateTime) {
		this.endUpdateTime = endUpdateTime;
	}

	// ----------------------------- 以下是重写的toString方法 ------------------------
	@Override
	public String toString() {
		return "CatSearch [name=" + name + ", sex=" + sex + ", minAge=" + minAge + ", maxAge=" + maxAge
				+ ", startBirthday=" + startBirthday + ", endBirthday=" + endBirthday + ", startUpdateTime="
				+ startUpdateTime + ", endUpdateTime=" + endUpdateTime + "]";
	}

}
