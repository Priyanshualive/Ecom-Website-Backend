package com.spring.ecom_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.ecom_project.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE "+ 
	        "LOWER(p.name) LIKE LOWER(CONCAT('%' ,:keyword ,'%')) OR "+
			"LOWER(p.description) LIKE LOWER(CONCAT('%' ,:keyword ,'%')) OR "+
			"LOWER(p.brand) LIKE LOWER(CONCAT('%' ,:keyword ,'%')) OR "+
			"LOWER(p.category) LIKE LOWER(CONCAT('%' ,:keyword ,'%'))")
	List<Product> searchProducts(String keyword);

}