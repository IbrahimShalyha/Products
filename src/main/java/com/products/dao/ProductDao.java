package com.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.products.customexception.IdNotFoundException;
import com.products.entity.Product;
import com.products.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository pr;

	public String setProduct(Product product) {
		pr.save(product);
		return "GIVEN DATA SAVED SUCCESSFULLY";
	}

	public String setAllProduct(List<Product> products) {
		pr.saveAll(products);
		return "ALL DATA'S SAVED SUCCESSFULLY";
	}

	public List<Product> getAllProduct() {
		return pr.findAll();
	}

	public Product getById(int x) throws IdNotFoundException {
		return pr.findById(x).orElseThrow(() -> new IdNotFoundException("GIVEN DATA IS INVALID"));
	}

	public List<Product> getByBrand(String x) {
		return pr.getByBrand(x);
	}

	public List<Product> getByName(String x) {
		return pr.getByName(x);
	}

}
