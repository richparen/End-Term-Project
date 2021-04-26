package kz.iitu.endtermspring.repository;

import kz.iitu.endtermspring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
    List<Book> getBooksByNameContainsOrAuthorContains(String name, String author);
}
