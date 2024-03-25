package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();		// select * from product in SQL
	}											// select p from Product p in HQL/JPQL
	
	
	public String storeProduct(Product product) {
		
	Optional<Product> result=productRepository.findById(product.getPid());
	if(result.isPresent()) {
		return "Product id must be unique";
	}else {
		productRepository.save(product);
		return "Product record stored successfully";
	}
	}
	
	public String deleteProduct(int pid) {
		
		//Optional<Product> result=productRepository.findById(pid);
		if(productRepository.existsById(pid)) {
			productRepository.deleteById(pid);
			return "Product deleted successfully";
		}else {
			return "Product record not present";
		}
		}
}



