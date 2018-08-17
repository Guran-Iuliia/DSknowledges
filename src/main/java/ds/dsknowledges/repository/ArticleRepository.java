package ds.dsknowledges.repository;

import ds.dsknowledges.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
