package com.example.emt_lab.config;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Book;
import com.example.emt_lab.model.Country;
import com.example.emt_lab.model.enums.BookCategory;
import com.example.emt_lab.repository.AuthorRepository;
import com.example.emt_lab.repository.BookRepository;
import com.example.emt_lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();


    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Maine", "USA");
        Country country2 = new Country("Germany", "Europe");
        Country country3 = new Country("Russia", "Europe");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Author author1 = new Author("Steven", "King", country1);
        Author author2 = new Author("Franz", "Kafka", country2);
        Author author3 = new Author("Leo", "Tolstoy", country3);

        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);

        Book book1 = new Book("The Shining", BookCategory.NOVEL, author1, 50);
        Book book2 = new Book("The Trial", BookCategory.NOVEL, author2, 150);
        Book book3 = new Book("War And Peace", BookCategory.NOVEL, author3, 300);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
    }
}
