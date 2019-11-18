package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller
public class CityController {

	@Autowired
	private CityService cityService;

	/**
	 * http://localhost:8080/excep
	 * 
	 * @return
	 */
	@RequestMapping("/excep")
	public String excep() {
		int k = 4 / 0;
		return "city";
	}

	/**
	 * http://localhost:8080/index
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public @ResponseBody String index() {
		return "SpringBoot SSM框架";
	}

	/**
	 * http://localhost:8080/api/city/1
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
	public String findOneCity(Model model, @PathVariable("id") Long id) {
		model.addAttribute("city", cityService.findCityById(id));
		return "city";
	}

	/**
	 * http://localhost:8080/api/city
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/api/city", method = RequestMethod.GET)
	public String findAllCity(Model model) {
		List<City> cityList = cityService.findAllCity();
		model.addAttribute("cityList", cityList);
		return "cityList";
	}
}
