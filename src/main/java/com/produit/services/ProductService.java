package com.produit.services;

import com.produit.models.Product;

import java.util.List;

public interface ProductService {
  //  int countAll();
    List<Product> findAll();
    Product getProductById(int pi);
    void AddProduct(Product p);
    void deleteProduct(Product p);
    void updateProduct(Product p);

}
