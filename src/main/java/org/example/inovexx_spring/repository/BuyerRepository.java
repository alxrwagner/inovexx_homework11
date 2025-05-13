package org.example.inovexx_spring.repository;

import org.example.inovexx_spring.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
