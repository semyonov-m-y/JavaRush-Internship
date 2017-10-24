package ru.maxim.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.maxim.bookmanager.model.Book;
import ru.maxim.bookmanager.service.BookService;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;
    private final int pageSize = 10;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/getAllBooks"})
    public ModelAndView getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ModelAndView("books", "books", bookList);
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.getAllBooks());

        return "books";
    }

    @RequestMapping(value = "bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

    @RequestMapping("searchBook")
    public ModelAndView searchBook(@RequestParam("searchBook") String title){
        List<Book> booksList = bookService.getAllBooks(title);
        return new ModelAndView("booksearch", "booksList", booksList);
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public ModelAndView listBooks(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("books");

        List<Book> books = bookService.getAllBooks();
        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(books);
        pagedListHolder.setPageSize(pageSize);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;

        modelAndView.addObject("page", page);

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("listBooks", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("listBooks", pagedListHolder.getPageList());
        }

        modelAndView.addObject("book", new Book());

        return modelAndView;
    }
}
