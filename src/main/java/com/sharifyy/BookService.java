package com.sharifyy;

import com.sharifyy.domain.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookService {
    private List<Book> availableBooks = new ArrayList<>();

    public List<Book> getAllBooks() {
        return availableBooks;
    }

    public Book getBookByTitle(String title) {
        return availableBooks.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("book not found"));
    }

    public Book addBook(Book aBook) {
        if (!availableBooks.contains(aBook))
            availableBooks.add(aBook);
        return aBook;
    }

    public void deleteBook(String isbn) {
        availableBooks.stream()
                .filter(book -> book.getIsbn().equals(isbn.toLowerCase()))
                .findFirst().ifPresent(book -> availableBooks.remove(book));
    }

    public Book editBook(String isbn,Book aBook) {
        return availableBooks.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .map(book -> {
                    Book.of(aBook.getTitle(), aBook.getPublisher(), aBook.getAuthors(), aBook.getIsbn());
                    return aBook;
                }).orElseThrow(() -> new NotFoundException("book not found"));
    }
}
