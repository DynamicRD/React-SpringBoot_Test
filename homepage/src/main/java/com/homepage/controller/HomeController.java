package com.homepage.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.homepage.mapper")
public class HomeController {
	
	
	@RequestMapping(value="/")
	public String home(Model model) {
		return "mainpage";
	}
}
