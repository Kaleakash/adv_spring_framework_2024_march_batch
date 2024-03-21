package com.controller;

import java.util.List;

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
	
	@RequestMapping(value = "deleteProduct",method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest req) {		// DI for both object. 
	
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		String result = productService.deleteProduct(pid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);		// request.setAttribute("msg",result)
		mav.setViewName("deleteProduct.jsp");
		return mav;
		
	}
	
	@RequestMapping(value = "updateProduct",method = RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest req, Product product) {		// DI for both object. 
		
		int pid = Integer.parseInt(req.getParameter("pid"));
	
		float price = Float.parseFloat(req.getParameter("price"));
		
		product.setPid(pid);
		product.setPrice(price);
		
		String result = productService.updateProduct(product);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);		// request.setAttribute("msg",result)
		mav.setViewName("updateProduct.jsp");
		return mav;
		
	}
	
	@RequestMapping(value = "searchProduct",method = RequestMethod.GET)
	public ModelAndView searchProductById(HttpServletRequest req) {		// DI for both object. 
	
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		String result = productService.searchProductById(pid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", result);		// request.setAttribute("msg",result)
		mav.setViewName("searchProduct.jsp");
		return mav;
		
	}
	
	@RequestMapping(value = "findProduct",method = RequestMethod.GET)
	public ModelAndView findAllProducts(HttpServletRequest req) {		// DI for both object. 
	
		
		
		List<Product> listofproducts = productService.findAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", listofproducts);		// request.setAttribute("msg",result)
		mav.setViewName("listOfProduct.jsp");
		return mav;
		
	}
	
}
