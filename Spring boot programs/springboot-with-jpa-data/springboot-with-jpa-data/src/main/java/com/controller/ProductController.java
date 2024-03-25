package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;



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
		String result = productService.storeProduct(product);
		product.setPid(0);
		product.setPname("");
		product.setPrice(0);
		model.addAttribute("product", product);
		
			List<Product> listOfProduct = productService.findAllProducts();
			model.addAttribute("products", listOfProduct);
		
			model.addAttribute("msg", result);
		return "index";
	}
	
	@RequestMapping(value = "/deleteProduct",method = RequestMethod.GET)
	public String deleteProductById(Model model, Product product,HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		String result = productService.deleteProduct(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		
	return "index";
	}
	
	@RequestMapping(value = "/updateProduct",method = RequestMethod.GET)
	public String searchProductById(Model model, HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		Product product = productService.searchProductById(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		//model.addAttribute("msg", result);
		
	return "index";
	}
}
