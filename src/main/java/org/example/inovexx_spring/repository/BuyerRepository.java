package org.example.inovexx_spring.repository;

import org.example.inovexx_spring.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    @Query(value = "SELECT b.name FROM buyers b" +
            "JOIN details d ON b.id = d.buyer_id" +
            "JOIN products p ON p.id = d.product_id" +
            "WHERE p.title = :productTitle" +
            "ORDER BY p.title DESK", nativeQuery = true)
    List<Buyer> findBuyersByProductTitle(@Param("productTitle") String productTitle);

    @Modifying
    @Query(value = "DELETE Buyer b FROM buyers WHERE name = :buyerName", nativeQuery = true)
    void removeBuyer(@Param("buyerName") String buyerName);
}
