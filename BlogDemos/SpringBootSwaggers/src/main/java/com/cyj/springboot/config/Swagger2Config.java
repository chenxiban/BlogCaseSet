package com.cyj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 
 * @Description: Swagger配置类
 * @ClassName: Swagger2Config.java
 * @author ChenYongJia
 * @Date 2018年8月11日 下午4:00:28
 * @Email 867647213@qq.com
 */
@Configuration
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		// 扫描控制器中Swagger2的注解
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.cyj.springboot.web")).paths(PathSelectors.any()).build();
	}

	// API描述信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档")
				.description("简单优雅的文章风格，https://blog.csdn.net/mrs_chens/category_8935373.html")
				.termsOfServiceUrl("https://blog.csdn.net/mrs_chens/category_8935373.html").version("1.0").build();
	}

}
