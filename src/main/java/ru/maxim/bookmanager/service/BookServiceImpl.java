package ru.maxim.bookmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxim.bookmanager.dao.BookDao;
import ru.maxim.bookmanager.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks(String titleName) {
        return this.bookDao.getAllBooks(titleName);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return this.bookDao.getAllBooks();
    }
}
