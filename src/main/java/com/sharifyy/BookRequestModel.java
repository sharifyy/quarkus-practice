package com.sharifyy;

import com.sharifyy.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestModel {
    private String title;
    private String publisher;
    private List<AuthorRequestModel> authors;
    private String isbn;
}
