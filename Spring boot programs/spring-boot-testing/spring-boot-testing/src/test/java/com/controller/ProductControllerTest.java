package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entity.Product;


@SpringBootTest
//@ExtendWith(SpringExtension.class)
class ProductControllerTest {

	@Autowired
	ProductController productController;
	
	@Test
	@Disabled
	void testGetProductInfo() {
	String result = productController.getProductInfo();
	assertEquals("Welcome to Spring boot with product api", result);
	}

	@Test
	public void productTest() {
		List<Product> listOfProduct = productController.findAllProducts();
		assertEquals(3, listOfProduct.size());
		assertEquals(1, listOfProduct.get(0).getPid());
		assertEquals("Sony TV", listOfProduct.get(0).getPname());
		assertEquals(95000, listOfProduct.get(0).getPrice());
	}
	
}
