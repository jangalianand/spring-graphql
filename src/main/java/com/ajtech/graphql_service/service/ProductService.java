package com.ajtech.graphql_service.service;

import com.ajtech.graphql_service.entity.Product;
import com.ajtech.graphql_service.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductFndByCatogery(String category){
        return productRepository.findBycatogery(category);
    }
    //sales team : update the stock of a product in (IS)
    public Product updateStock(int id, int stock){

        Product existingProduct= productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }



}
