package com.ajtech.graphql_service.controller;

import com.ajtech.graphql_service.entity.Product;
import com.ajtech.graphql_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @QueryMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category){
        return productService.getProductFndByCatogery(category);
    }


    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return productService.updateStock(id, stock);

    }


}
