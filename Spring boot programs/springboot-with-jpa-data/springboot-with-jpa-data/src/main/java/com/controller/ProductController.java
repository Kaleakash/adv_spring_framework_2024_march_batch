package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String open(Model model, Product product) {
	
	List<Product> listOfProduct = productService.findAllProducts();
	model.addAttribute("products", listOfProduct);
	
	model.addAttribute("product", product);
	return "index";
	}
	
	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public String addProductDetails(Model model, Product product) {
		System.out.println("I came here");
		String result = productService.storeProduct(product);
		product.setPid(0);
		product.setPname("");
		product.setPrice(0);
		model.addAttribute("product", product);
		System.out.println(result);
		model.addAttribute("msg", result);
		return "index";
	}
}
