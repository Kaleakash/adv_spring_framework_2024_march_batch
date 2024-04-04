package com.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.entity.Product;
import com.service.ProductService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductControllerMockTest {
	@InjectMocks
	ProductController productController;
	@Mock
	ProductService productService;
	@Test
	void testFindAllProducts() {
		// fake product data 
		List<Product> fakeProduct = new ArrayList<>();
		Product p1 = new Product(1,"Pen Drive",25000);
		fakeProduct.add(p1);
		// fake for product service 
		
		Mockito.when(productService.findAllProducts()).thenReturn(fakeProduct);
		
		
		// not test it 
		
		List<Product> listOfProduct = productController.findAllProducts();	// not going hit actual service layer 
		assertEquals(1, listOfProduct.size());
		assertEquals(1, listOfProduct.get(0).getPid());
		assertEquals("Pen Drive", listOfProduct.get(0).getPname());
		assertEquals(25000, listOfProduct.get(0).getPrice());
		
		
	}

}
