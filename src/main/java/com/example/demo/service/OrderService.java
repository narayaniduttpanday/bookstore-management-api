package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Order;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional // This ensures either everything succeeds or nothing changes
    public Order placeOrder(Long bookId, int quantity) {
        // 1. Check if the book exists
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

        // 2. Check if enough stock is available
        if (book.getStockQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock. Available: " + book.getStockQuantity());
        }

        // 3. Deduct the stock and save the updated book
        book.setStockQuantity(book.getStockQuantity() - quantity);
        bookRepository.save(book);

        // 4. Create the order record
        Order order = new Order();
        order.setBook(book);
        order.setQuantity(quantity);
        order.setTotalPrice(book.getPrice() * quantity);
        order.setOrderDate(LocalDateTime.now());

        // 5. Save the order to the 'orders' table
        return orderRepository.save(order);
    }
}