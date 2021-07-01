package com.sharifyy.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String publisher;
    private final List<Author> authors;
    private final String isbn;


    public static Book of(String title,String publisher,List<Author> authors,String isbn){
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("title can't be null");
        if(publisher == null || publisher.isEmpty()) throw new IllegalArgumentException("publisher can't be null");
        if(authors.isEmpty()) throw new IllegalArgumentException("the book must have at least one author");
        if(isbn == null || isbn.isEmpty()) throw new IllegalArgumentException("isbn can't be null");
        return new Book(title,publisher,authors,isbn);
    }
}
