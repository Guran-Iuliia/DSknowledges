package ds.dsknowledges.repository;

import ds.dsknowledges.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByArticleId(Long articleId);

    void deleteByArticleId(Long articleId);
}
