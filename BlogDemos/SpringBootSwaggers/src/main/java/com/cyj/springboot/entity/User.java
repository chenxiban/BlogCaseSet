package com.cyj.springboot.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @Description:
 * @ClassName: User.java
 * @author ChenYongJia
 * @Date 2018年8月11日 下午3:53:48
 * @Email 867647213@qq.com
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private int age;
	private Date ctm;

}
