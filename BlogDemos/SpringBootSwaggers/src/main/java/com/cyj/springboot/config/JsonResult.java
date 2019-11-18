package com.cyj.springboot.config;

import lombok.Data;

/**
 * 
 * @Description:
 * @ClassName: JsonResult.java
 * @author ChenYongJia
 * @Date 2018年8月11日 下午3:49:20
 * @Email 867647213@qq.com
 */
@Data
public class JsonResult {
	private String status;
	private Object result;

}
