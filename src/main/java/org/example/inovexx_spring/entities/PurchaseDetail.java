package org.example.inovexx_spring.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "details")
public class PurchaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "buyer_id")
    @ManyToOne
    private Buyer buyer;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
    @Column(name = "date",
    columnDefinition = "DATE")
    private LocalDate date;
    @Column(name = "product_cost")
    private BigDecimal costProduct;
}
