package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in class : "+getClass());
	}
	//add req handling method for testing model map n req params 
	@GetMapping("/multiply")//@RequestMapping(method=GET)
	public String multiplyNos(Model modelMap, @RequestParam int num1, @RequestParam int num2 ) {
		/*
		 * @RequestParam - method arg level annotaion
		 * It's for binding
		 * incoming request param -> method argument
		 * int num1 = Integer.parseInt(req.getParam("num1"));
		 * match req param name with method argument name
		 */
		//os.ui.model-i/f,request a holder of model attributes
		System.out.println("in multiply"+modelMap+""+num1+" "+num2);//empty map
		modelMap.addAttribute("multiply", num1*num2);
		return "/test/result";//ANV : /WEB-INF/views/test/result.jsp
	}

}
