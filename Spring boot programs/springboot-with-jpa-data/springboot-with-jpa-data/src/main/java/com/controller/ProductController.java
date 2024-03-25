package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	public String open() {
		
		return "index";
	}
}
