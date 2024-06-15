package com.ajtech.graphql_service.repo;

import com.ajtech.graphql_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findBycatogery(String catogery);
}
