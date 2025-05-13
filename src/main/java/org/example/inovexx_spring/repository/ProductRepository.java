package org.example.inovexx_spring.repository;

import org.example.inovexx_spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.* " +
            "FROM products p" +
            "JOIN details d ON p.id = d.product_id" +
            "JOIN buyers b ON b.id = d.buyer.id" +
            "WHERE b.name = :buyerName" +
            "ORDER BY d.date DESK")
    List<Product> showProductByBuyerName(@Param("buyerName") String buyerName);
}
