package kz.iitu.endtermspring.service;

import kz.iitu.endtermspring.entity.Comment;

import java.util.List;

public interface ICommentService {
    Comment createNew(Comment comment);
    Comment updateComment(Comment comment);
    void deleteCommentById(Long id);
    List<Comment> getCommentsByBookId(Long bookId);
}
