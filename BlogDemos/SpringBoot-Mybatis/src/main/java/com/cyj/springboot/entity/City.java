package com.cyj.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class City {

	private Integer id;
	private Integer provinceId;
	private String cityName;
	private String description;

}
