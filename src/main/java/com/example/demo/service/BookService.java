package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 1. Create a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // 2. Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 3. Get a specific book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // 4. Update an existing book
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setIsbn(updatedBook.getIsbn());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setStockQuantity(updatedBook.getStockQuantity());
            existingBook.setImageUrl(updatedBook.getImageUrl());
            return bookRepository.save(existingBook);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id)); 
    }

    // 5. Delete a book
//    public void deleteBook(Long id) {
//        bookRepository.deleteById(id);
//    }
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }
}