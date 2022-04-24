package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Book;
import com.example.emt_lab.model.dto.BookDto;
import com.example.emt_lab.model.enums.BookCategory;
import com.example.emt_lab.repository.BookRepository;
import com.example.emt_lab.service.AuthorService;
import com.example.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        String name = bookDto.getName();
        Author author = authorService.findById(bookDto.getAuthor());
        int copies = bookDto.getAvailableCopies();
        BookCategory category = BookCategory.valueOf(String.valueOf(bookDto.getCategory()));
        return Optional.of(bookRepository.save(new Book(name, category, author, copies)));
    }


    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book taken = findById(id).orElseThrow(RuntimeException::new);
        int copies = taken.getAvailableCopies();
        if (copies > 0)
            copies = copies - 1;
        taken.setAvailableCopies(copies);

        bookRepository.save(taken);
        return Optional.of(taken);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book editBook = findById(id).orElseThrow(RuntimeException::new);
        editBook.setAuthor(authorService.findById(bookDto.getAuthor()));
        editBook.setName(bookDto.getName());
        editBook.setAvailableCopies(bookDto.getAvailableCopies());
        editBook.setCategory(BookCategory.valueOf(String.valueOf(bookDto.getCategory())));

        bookRepository.save(editBook);
        return Optional.of(editBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}