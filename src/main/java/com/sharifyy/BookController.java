package com.sharifyy;

import com.sharifyy.domain.Author;
import com.sharifyy.domain.Book;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response createBook(BookRequestModel aBook) {
        return Response.status(Response.Status.CREATED).entity(
                bookService.addBook(
                        Book.of(
                                aBook.getTitle(),
                                aBook.getPublisher(),
                                aBook.getAuthors().stream().map(author -> Author.of(author.getName())).collect(Collectors.toList()),
                                aBook.getIsbn())
                )).build();

    }

    @DELETE
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBookByIsbn(@PathParam String isbn) {
        bookService.deleteBook(isbn);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam String isbn, BookRequestModel book) {
        return bookService.editBook(isbn, Book.of(
                book.getTitle(),
                book.getPublisher(),
                book.getAuthors().stream().map(author -> Author.of(author.getName())).collect(Collectors.toList()),
                book.getIsbn())
        );
    }

}

