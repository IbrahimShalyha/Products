package com.products.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.customexception.BrandNotFoundException;
import com.products.customexception.IdNotFoundException;
import com.products.customexception.NameNotFoundException;
import com.products.dao.ProductDao;
import com.products.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao pd;

	public String setProduct(Product product) {
		return pd.setProduct(product);
	}

	public String setAllProduct(List<Product> products) {
		return pd.setAllProduct(products);
	}

	public List<Product> getAllProduct() {
		return pd.getAllProduct();
	}

	public Product getById(int x) throws IdNotFoundException {
		return pd.getById(x);
	}

	public Product getMax() {
		return getAllProduct().stream().max(Comparator.comparingInt(Product::getPrice)).get();

	}

	public Product getMin() {
		return getAllProduct().stream().min(Comparator.comparingInt(Product::getPrice)).get();
	}

	public List<Product> getByBrand(String x) throws BrandNotFoundException {
		List<Product> z = pd.getByBrand(x);
		if (z.isEmpty()) {
			throw new BrandNotFoundException("INVALID DATA");
		} else {
			return z;
		}

	}

	public List<Product> getByName(String x) throws NameNotFoundException {
		List<Product> z = pd.getByName(x);
		if (z.isEmpty()) {
			throw new NameNotFoundException("INVALID DATA");
		} else {
			return z;
		}
	}

	public List<Product> getByModel(String x) {
		return getAllProduct().stream().filter(b -> b.getModel().equalsIgnoreCase(x)).collect(Collectors.toList());
	}

}
