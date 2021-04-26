package kz.iitu.endtermspring.service.implement;

import kz.iitu.endtermspring.entity.Comment;
import kz.iitu.endtermspring.repository.CommentRepository;
import kz.iitu.endtermspring.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createNew(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentsByBookId(Long bookId) {
        return commentRepository.getCommentsByBookId(bookId);
    }
}
