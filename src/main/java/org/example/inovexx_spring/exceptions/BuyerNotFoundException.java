package org.example.inovexx_spring.exceptions;

public class BuyerNotFoundException extends RuntimeException{
    public BuyerNotFoundException(Long id){
        super("Buyer not found with ID:" + id);
    }
}
