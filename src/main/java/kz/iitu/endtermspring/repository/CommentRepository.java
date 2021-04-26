package kz.iitu.endtermspring.repository;

import kz.iitu.endtermspring.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByBookId(Long id);
}
