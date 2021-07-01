package com.sharifyy.domain;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Author {

    private final String name;

    public static Author of(String name){
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("name can't be null");
        return new Author(name);
    }
}
