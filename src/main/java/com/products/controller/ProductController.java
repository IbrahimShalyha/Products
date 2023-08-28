package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.customexception.BrandNotFoundException;
import com.products.customexception.IdNotFoundException;
import com.products.customexception.NameNotFoundException;
import com.products.entity.Product;
import com.products.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	ProductService ps;

	@PostMapping(value = "/setProduct")
	public String setProduct(@RequestBody Product product) {
		return ps.setProduct(product);
	}

	@PostMapping(value = "/setAllProduct")
	public String setAllProduct(@RequestBody List<Product> products) {
		return ps.setAllProduct(products);
	}

	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct() {
		return ps.getAllProduct();
	}

	@GetMapping(value = "/getById/{x}")
	public Product getById(@PathVariable int x) throws IdNotFoundException {
		return ps.getById(x);
	}

	@GetMapping(value = "/getMax")
	public Product getMax() {
		return ps.getMax();
	}

	@GetMapping(value = "/getMin")
	public Product getMin() {
		return ps.getMin();
	}

	@GetMapping(value = "/getByBrand/{x}")
	public List<Product> getByBrand(@PathVariable String x) throws BrandNotFoundException {
		return ps.getByBrand(x);
	}

	@GetMapping(value = "/getByName/{x}")
	public List<Product> getByName(@PathVariable String x) throws NameNotFoundException {
		return ps.getByName(x);
	}

	@GetMapping(value = "/getByModel/{x}")
	public List<Product> getByModel(@PathVariable String x) {
		return ps.getByModel(x);
	}

	@GetMapping(value = "/getString")
	public String getString() {
		return "Hello World";
	}
}
