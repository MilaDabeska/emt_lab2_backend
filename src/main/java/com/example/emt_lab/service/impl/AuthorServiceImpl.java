package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Country;
import com.example.emt_lab.repository.AuthorRepository;
import com.example.emt_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Author create(String name, String surname, Country country) {
        return authorRepository.save(new Author(name, surname, country));
    }
}
