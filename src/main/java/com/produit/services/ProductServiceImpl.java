package com.produit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.produit.repository.ProduitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.produit.models.Product;

@Service 
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("hibernateProduitRepository")
	private ProduitDAO repository;

	public ProductServiceImpl() {

	}
/*
	public List<Product> getAllProducts() {

/*
		
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product("120", "IPHONE X", "This is my Iphone ", 400, "Apple Inc"));
		listOfProducts.add(new Product("121", "Samsung Y", "This is my Samsung ", 800, "Samsung Inc"));
		listOfProducts.add(new Product("122", "LG Z", "This is  LG ", 300, "LG Inc"));

		return listOfProducts;




	}*/

	public Product getProductById(int id) {

		Predicate<Product> byId = p -> p.getId() == id;
		return filterProducts(byId);
	}

	@Override
	public void AddProduct(Product P) {
		 repository.addProduct( P);
	}

	@Override
	public void deleteProduct(Product p) {
		 repository.findAll().remove(p);

	}

	@Override
	public void updateProduct(Product p) {
		 repository.updateProduct(p);
	}

	public Product filterProducts(Predicate<Product> strategy) {
		return repository.findAll().stream().filter(strategy).findFirst().orElse(null);
	}



	@Override
	public List<Product> findAll() {
			return repository.findAll();
	}
}
