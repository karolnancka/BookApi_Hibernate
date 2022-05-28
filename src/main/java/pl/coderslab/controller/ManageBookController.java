package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.BookService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {


    private final BookService bookService;
    private final BookRepository bookRepository;

    public ManageBookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }


    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }


    @GetMapping("/add")
    public String getAddForm(Model m) {
        m.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid final Book book, final BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "books/add";
        }
        bookService.add(book);
        return "redirect:all";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "books/getOne";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable long id, Model model){
        bookService.delete(id);
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books/all";
    }

    @GetMapping("/edit/{id}")
    public String editById(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.get(id));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }
}

