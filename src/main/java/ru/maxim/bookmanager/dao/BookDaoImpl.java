package ru.maxim.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maxim.bookmanager.model.Book;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book default " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully updated. Book default " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if (book != null) {
            session.delete(book);
        }
        logger.info("Book successfully removed. Book default " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book default " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        return bookList;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Book> getAllBooks(String item) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "FROM Book b WHERE b.bookTitle like 'item'";
        List<Object[]> bookObjects = session.createQuery(query).list();
        List<Book> books = new ArrayList<Book>();
        for (Object[] bookObject : bookObjects) {
            Book book = new Book();
            int id = (int) bookObject[0];
            String title = (String) bookObject[1];
            String description = (String) bookObject[2];
            String author = (String) bookObject[3];
            int isbn = (int) bookObject[4];
            int printYear = (int) bookObject[5];
            int readAlready = (int) bookObject[6];
            book.setId(id);
            book.setBookTitle(title);
            book.setDescription(description);
            book.setBookAuthor(author);
            book.setIsbn(isbn);
            book.setPrintYear(printYear);
            book.setReadAlready(readAlready);
            books.add(book);
        }
        System.out.println(books);

        return books;
    }
}