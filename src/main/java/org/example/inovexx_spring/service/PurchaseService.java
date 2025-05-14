package org.example.inovexx_spring.service;

import lombok.RequiredArgsConstructor;
import org.example.inovexx_spring.entities.Buyer;
import org.example.inovexx_spring.entities.Product;
import org.example.inovexx_spring.entities.PurchaseDetail;
import org.example.inovexx_spring.exceptions.BuyerNotFoundException;
import org.example.inovexx_spring.exceptions.ProductNotFoundException;
import org.example.inovexx_spring.repository.BuyerRepository;
import org.example.inovexx_spring.repository.ProductRepository;
import org.example.inovexx_spring.repository.PurchaseDetailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;
    private final PurchaseDetailRepository purchaseRepository;

    public PurchaseDetail buy(Long productId, Long buyerId){
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException(productId));
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(() -> new BuyerNotFoundException(buyerId));
        PurchaseDetail detail = new PurchaseDetail();

        detail.setBuyer(buyer);
        detail.setProduct(product);
        detail.setCostProduct(product.getCost());
        detail.setDate(LocalDate.now());

        return purchaseRepository.save(detail);
    }
}
