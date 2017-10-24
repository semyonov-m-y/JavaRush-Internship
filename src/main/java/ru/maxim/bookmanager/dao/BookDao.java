package ru.maxim.bookmanager.dao;

import ru.maxim.bookmanager.model.Book;
import java.util.List;

public interface BookDao {

    void addBook(Book book);
    void updateBook(Book book);
    void removeBook(int id);
    Book getBookById(int id);
    List<Book> getAllBooks();
    List<Book> getAllBooks(String bookName);
}
