package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Product;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public ModelAndView storeProduct(HttpServletRequest req, Product product) {		// DI for both object. 
		
		String pname = req.getParameter("pname");
		float price = Float.parseFloat(req.getParameter("price"));
		
		product.setPname(pname);
		product.setPrice(price);
		
		String result = productService.storeProduct(product);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);		// request.setAttribute("msg",result)
		mav.setViewName("addProduct.jsp");
		return mav;
		
	}
	
}
