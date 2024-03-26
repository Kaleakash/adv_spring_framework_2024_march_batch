package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Orders;
import com.entity.Product;
import com.service.OrdersService;
import com.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String open(Model model, Product product) {
	
	String name="Store Product"; 
	
	List<Product> listOfProduct = productService.findAllProducts();
	List<Object[]> orderdetails = productService.orderDetails();
	
	model.addAttribute("products", listOfProduct);
	model.addAttribute("buttonValue", name);
	model.addAttribute("product", product);
	model.addAttribute("orderdetails", orderdetails);
	
	System.out.println(listOfProduct);
	return "index";
	}
	
	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public String addProductDetails(Model model, Product product,HttpServletRequest req) {
		String b1 = req.getParameter("b1");
		String result="";
		String name=""; 
		if(b1.equals("Store Product")) {
			result = productService.storeProduct(product);
		}else {
			result = productService.updateProduct(product);
		}
		name = "Store Product";
		product.setPid(0);
		product.setPname("");
		product.setPrice(0);
		model.addAttribute("product", product);
		List<Product> listOfProduct = productService.findAllProducts();
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		model.addAttribute("products", listOfProduct);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		return "index";
	}
	
	@RequestMapping(value = "/deleteProduct",method = RequestMethod.GET)
	public String deleteProductById(Model model, Product product,HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		System.out.println("pid is "+pid);
		String name = "Store Product";
		String result = productService.deleteProduct(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
	return "index";
	}
	
	@RequestMapping(value = "/updateProduct",method = RequestMethod.GET)
	public String searchProductById(Model model, HttpServletRequest req) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		String name="Update Product"; 
		Product product = productService.searchProductById(pid);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("buttonValue", name);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
		//model.addAttribute("msg", result);
		
	return "index";
	}
	
	
	@RequestMapping(value = "/orderPlace",method = RequestMethod.GET)
	public String placeOrder(Model model, HttpServletRequest req, Orders order,Product product) {
		int pid = Integer.parseInt(req.getParameter("pid"));
		order.setPid(pid);
		String name="Store Product"; 
		String result = ordersService.placeOrder(order);
		List<Product> listOfProduct = productService.findAllProducts();
		model.addAttribute("products", listOfProduct);
		model.addAttribute("product", product);
		model.addAttribute("msg", result);
		model.addAttribute("buttonValue", name);
		//model.addAttribute("msg", result);
		List<Object[]> orderdetails = productService.orderDetails();
		model.addAttribute("orderdetails", orderdetails);
	return "index";
	}
}
