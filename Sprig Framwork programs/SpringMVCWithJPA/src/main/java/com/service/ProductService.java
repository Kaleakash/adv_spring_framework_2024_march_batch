package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		return productDao.storeProduct(product);
	}
	
	public String deleteProduct(int pid) {
		return productDao.deleteProduct(pid);
	}
	
	public String updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	
	public String searchProductById(int pid) {
		Product p = productDao.searchProductById(pid);
		if(p==null) {
			return "Product not present";
		}else {
			return p.toString();
		}
	}
	
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}
	
	public List<Integer> findAllProductIds() {
		return productDao.findAllProductId();
	}
	
	public List<String> findAllProductNames() {
		return productDao.findAllProductName();
	}
	
	public List<Object[]> findAllProductNamesAndPrice() {
		return productDao.findAllProductNameAndPrice();
	}
	
	public List<Product> findAllProductsByPrice(float price) {
		return productDao.findAllProductBySalary(price);
	}
}
