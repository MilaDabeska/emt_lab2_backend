package com.example.emt_lab.controller;

import com.example.emt_lab.model.Book;
import com.example.emt_lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String homePage(Model model){
        List<Book> books= bookService.findAll();
        model.addAttribute("books",books);
        return "home";
    }
}
