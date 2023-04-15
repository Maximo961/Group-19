package com.group19.bookstore.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Author {
    private String name;

    private Integer id;


}
