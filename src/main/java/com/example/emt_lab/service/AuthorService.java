package com.example.emt_lab.service;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Country;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author create(String name, String surname, Country country);
}
