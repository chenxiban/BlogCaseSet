package com.cyj.springboot.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "studenttb")
public class Student implements Serializable {

	@Id // 实体类的主键
	@GeneratedValue // 自动增长列
	@OrderBy // 数据加载顺序
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:学生自动增长主键'  ")
	private Integer studentId;
	@Column(length = 20) // 字符长度20
	private String studentName;
	@Column(columnDefinition = "char(1) comment '备注:学生姓名' ")
	private String studentSex;
	@Column(columnDefinition = "int unsigned DEFAULT 0 comment '备注:学生年龄'  ")
	private Integer studentAge;

	private Date studentBirthday;
//	@CreationTimestamp@UpdateTimestamp	//插入,修改时自动维护时间戳
	@Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false, insertable = false)
	private Timestamp updateTime;
	@Transient // 临时参数,不映射到数据库表字段
	private String studentSpare;
	@JsonIgnore
	@ManyToOne(targetEntity = Clazz.class)
	@JoinColumn(name = "student_clazz_id") // 副表中的外键字段名称
	private Clazz clazz;

	@Transient
	private String studentClazzName;// 学生所在班级名称

	// ----------------------------- 以下是构造方法 ------------------------

	/**
	 * 班级属性为空时取学生实体的班级名称
	 * 
	 * @return
	 */
	public String getStudentClazzNameIgnoreEmptyClazz() {
		return studentClazzName;

	}

	/**
	 * 给JSON转换器使用
	 * 
	 * @return
	 */
	public String getStudentClazzName() {
		if (clazz != null) {
			System.out.println("学生实体中的班级实体是空!!!");
			return clazz.getClazzName();
		} else {
			return studentClazzName;
		}

	}

	public void setStudentClazzName(String studentClazzName) {
		this.studentClazzName = studentClazzName;
	}

	// ----------------------------- 以下是Getter和setter方法 ------------------------
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getStudentSpare() {
		return studentSpare;
	}

	public void setStudentSpare(String studentSpare) {
		this.studentSpare = studentSpare;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	// ----------------------------- 以下是重写的toString方法 ------------------------
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentAge=" + studentAge + ", studentBirthday=" + studentBirthday + ", updateTime=" + updateTime
				+ ", studentSpare=" + studentSpare + "]";
	}

	public String showStudent() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentAge=" + studentAge + ", studentBirthday=" + studentBirthday + ", updateTime=" + updateTime
				+ ", studentSpare=" + studentSpare + "]";
	}

	public String showStudentAndClazz() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentAge=" + studentAge + ", studentBirthday=" + studentBirthday + ", updateTime=" + updateTime
				+ ", studentSpare=" + studentSpare + ", clazz=" + clazz + "]";
	}

}
