package org.example.inovexx_spring.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Product not found with ID:" + id);
    }
}
