package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // This end-point will handle placing a new order
    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestParam Long bookId, @RequestParam int quantity) {
        try {
            Order order = orderService.placeOrder(bookId, quantity);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // This catches the "Insufficient Stock" or "Book Not Found" errors
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}