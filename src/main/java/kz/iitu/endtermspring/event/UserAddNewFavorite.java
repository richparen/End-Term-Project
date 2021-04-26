package kz.iitu.endtermspring.event;

import kz.iitu.endtermspring.entity.Book;
import kz.iitu.endtermspring.entity.User;
import org.springframework.context.ApplicationEvent;

public class UserAddNewFavorite extends ApplicationEvent {
    private User user;
    private Book book;

    public UserAddNewFavorite(Object source, User user, Book book) {
        super(source);
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
