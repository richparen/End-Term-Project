package kz.iitu.endtermspring.service;

import kz.iitu.endtermspring.entity.Book;
import kz.iitu.endtermspring.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User createNew(User user);
    User updateUsername(Long id, String username);
    User addBookToFavorites(Long userId, Book book);
    User deleteBookFromFavorites(Long userId, Book book);
}
