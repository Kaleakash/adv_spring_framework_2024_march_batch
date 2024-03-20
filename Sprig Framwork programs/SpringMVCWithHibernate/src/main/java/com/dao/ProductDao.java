package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;
	
	public String storeProduct(Product product) {
		EntityManager manager = emf.createEntityManager();
		
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
			manager.persist(product);        // insert query 
		tran.commit();
	
		return "Record inserted successfully";
	}
}
