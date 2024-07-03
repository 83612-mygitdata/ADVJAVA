package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//singleton & eager
@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor : "+getClass());
	}
	//add req handling method with ann.
	//HandlerMapping
	//key = "/"
	//Value = com.sunbeam.controller.HomePageController
	@RequestMapping("/")
	public String renderHomePage() {
		System.out.println("in render Home Page");
		return "/index";//Handler returns LVN -> DS -> VR -> AVN(/WEB-INF/views/index.jsp) -> forward
		//the clnt to the view layer (jsp)
	}

}
