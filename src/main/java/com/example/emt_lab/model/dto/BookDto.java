package com.example.emt_lab.model.dto;

import com.example.emt_lab.model.enums.BookCategory;
import lombok.Data;

@Data
public class BookDto {
    private String name;

    private BookCategory category;

    private Long author;

    private int availableCopies;

    public BookDto() {}

    public BookDto(String name, BookCategory category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
