package com.sharifyy;

import com.sharifyy.domain.Author;
import com.sharifyy.domain.Book;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/books")
public class BookController {

    private final BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookByTitle(@PathParam String title) {
        return bookService.getBookByTitle(title);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book createBook(BookRequestModel aBook) {
        return bookService.addBook(Book.of(
                aBook.getTitle(),
                aBook.getPublisher(),
                aBook.getAuthors().stream().map(author->Author.of(author.getName())).collect(Collectors.toList()),
                aBook.getIsbn())
        );
    }

    @DELETE
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBookByIsbn(@PathParam String isbn) {
        bookService.deleteBook(isbn);
    }

    @PUT
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam String isbn, BookRequestModel book) {
        return bookService.editBook(isbn, Book.of(
                book.getTitle(),
                book.getPublisher(),
                book.getAuthors().stream().map(author->Author.of(author.getName())).collect(Collectors.toList()),
                book.getIsbn())
        );
    }

}

