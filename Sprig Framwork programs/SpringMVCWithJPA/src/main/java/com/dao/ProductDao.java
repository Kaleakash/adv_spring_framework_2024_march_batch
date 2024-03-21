package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
	
	public String updateProduct(Product product) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Product p = manager.find(Product.class, product.getPid()); // select * from product where pid = 100
		if(p==null) {
			return "Product not present";
		}else {
			tran.begin();
				p.setPrice(product.getPrice());
					manager.merge(p);				// update query 
			tran.commit();
			return "Product record updated successfully";
		}
	}
	
	public String deleteProduct(int pid) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Product p = manager.find(Product.class, pid); // select * from product where pid = 100
		if(p==null) {
			return "Product not present";
		}else {
			tran.begin();
					manager.remove(p);			// delete query 
			tran.commit();
			return "Product record deleted successfully";
		}
	}
	
	public Product searchProductById(int pid) {
		EntityManager manager = emf.createEntityManager();
		Product p = manager.find(Product.class, pid); // select * from product where pid = 100
		return p;
	}
	
	
	public List<Product> findAllProducts() {
		EntityManager manager = emf.createEntityManager();
		Query qry= manager.createQuery("select p from Product p");
		List<Product> listOfProducts = qry.getResultList();
		return listOfProducts;
	}
	
	public List<Integer> findAllProductId() {
		EntityManager manager = emf.createEntityManager();
		Query qry= manager.createQuery("select p.pid from Product p");
		List<Integer> listOfProducts = qry.getResultList();
		return listOfProducts;
	}
	
	public List<String> findAllProductName() {
		EntityManager manager = emf.createEntityManager();
		Query qry= manager.createQuery("select p.pname from Product p");
		List<String> listOfProducts = qry.getResultList();
		return listOfProducts;
	}
	
	public List<Object[]> findAllProductNameAndPrice() {
		EntityManager manager = emf.createEntityManager();
		Query qry= manager.createQuery("select p.pname,p.price from Product p");	// join 
		List<Object[]> listOfProducts = qry.getResultList();
		return listOfProducts;			// obj[0] name, obj[1]
	}
	
	public List<Product> findAllProductBySalary(float p_price) {
		EntityManager manager = emf.createEntityManager();
//		Query qry= manager.createQuery("select p from Product p where p.price > 40000");	
		Query qry= manager.createQuery("select p from Product p where p.price > :l_price");
		qry.setParameter("l_price", p_price);
		List<Product> listOfProducts = qry.getResultList();
		return listOfProducts;			// obj[0] name, obj[1]
	}
}
