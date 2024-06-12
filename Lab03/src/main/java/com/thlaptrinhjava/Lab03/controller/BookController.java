package com.thlaptrinhjava.Lab03.controller;


import com.thlaptrinhjava.Lab03.entity.Book;
import com.thlaptrinhjava.Lab03.services.BookService;
import com.thlaptrinhjava.Lab03.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        if(bookService.getBookById(id)==null)
            return "not-found";
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model ){
        Book editBook = bookService.getBookById(id);
        if(editBook!=null){
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @Valid Book updateBook, BindingResult result){
        if(bookService.getBookById(updateBook.getId())==null)
            return "not-found";
        if(result.hasErrors()){
            updateBook.setId(id);
            return "book/edit";
        }
        bookService.updateBook(updateBook);
        return "redirect:/books";
    }

}
