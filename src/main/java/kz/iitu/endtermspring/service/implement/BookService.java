package kz.iitu.endtermspring.service.implement;

import kz.iitu.endtermspring.entity.Book;
import kz.iitu.endtermspring.repository.BookRepository;
import kz.iitu.endtermspring.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByNameOrAuthor(String name, String author) {
        return bookRepository.getBooksByNameContainsOrAuthorContains(name, author);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book createNew(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book updateBookPrice(Long bookId, Integer price) {
        Book book = bookRepository.getOne(bookId);
        book.setPrice(price);
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
