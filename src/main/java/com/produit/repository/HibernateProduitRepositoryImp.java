package com.produit.repository;

import com.produit.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("productionsDAO")
@Qualifier("hibernateProduitRepository")
 public class HibernateProduitRepositoryImp implements ProduitDAO {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/produit?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "lili";

    public HibernateProduitRepositoryImp() {
        System.out.println("Constructeur Vide pour HibernateProduitRepositoryImp");
    }

    public List<Product> findAll() {

        List<Product> productList = new ArrayList<>();
            try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, price, seller  FROM PRODUIT")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return productList;

    }

    @Override
    public Product findById() {
        return null;
    }

    @Override
    public void addProduct(Product p) {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("Insert into  PRODUIT values(p.getName(),p.getDescription(),p.getPrice(),p.getSeller())")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
        }

    catch (SQLException e) {

        System.out.println(e.getMessage());
    }
    }

    @Override
    public void deleteProduct(Product p) {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(" delete from Produit  where id=p.getId() ")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
        }

        catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateProduct(Product p) {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(" update Produit set nom=p.getNom(), description = p.description,  where id=p.getId() ")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
        }

        catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }


    @PostConstruct
    void initBeanTest(){
    System.out.println("HibernateProduitRepositoryImp init");
}
}
