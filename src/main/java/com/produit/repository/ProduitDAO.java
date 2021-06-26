package com.produit.repository;

import com.produit.models.Product;

import java.util.List;

public interface ProduitDAO {
    List<Product> findAll();
    Product findById();
    void addProduct(Product p);
    void deleteProduct(Product p);
    void updateProduct(Product p);

}
