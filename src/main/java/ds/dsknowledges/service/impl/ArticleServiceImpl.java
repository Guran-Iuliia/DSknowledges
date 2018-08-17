package ds.dsknowledges.service.impl;

import ds.dsknowledges.dto.ArticleDTO;
import ds.dsknowledges.dto.ArticleResponseDTO;
import ds.dsknowledges.exeption.NoSuchArticleExeption;
import ds.dsknowledges.model.Article;
import ds.dsknowledges.model.Comment;
import ds.dsknowledges.repository.ArticleRepository;
import ds.dsknowledges.repository.CommentRepository;
import ds.dsknowledges.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    private static final int LIMIT = 6;

    /**
     * {@inheritDoc}.
     */
    @Override
    public ArticleResponseDTO findAll(int page) {
        List<Article> articles = articleRepository.findAll(new PageRequest(page, LIMIT)).getContent();
        long count = articleRepository.count();
        List<ArticleDTO> list = toArticleDTO(articles);
        return new ArticleResponseDTO(list, count);
    }

    @Override
    public Article save(Article article) {
        Assert.notNull(article, "article is null");
        article.setDate(LocalDate.now().toString());
        return articleRepository.save(article);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "id is null");
        articleRepository.delete(id);
        commentRepository.deleteByArticleId(id);
    }

    @Override
    public ArticleDTO findById(Long id) {
        Article article = articleRepository.findOne(1L);
        if (article == null) {
            throw new NoSuchArticleExeption();
        }
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setName(article.getName());
        articleDTO.setContent(article.getContent());
        articleDTO.setDate(article.getDate());
        List<Comment> comments = commentRepository.findAllByArticleId(article.getId());
        articleDTO.setComments(comments);
        return articleDTO;
    }

    /**
     * Mapper for article entity.
     */
    private List<ArticleDTO> toArticleDTO(List<Article> articles) {
        List<ArticleDTO> articleDTOList = new LinkedList<>();
        articles.forEach(s -> {
            ArticleDTO articleDTO = new ArticleDTO();
            articleDTO.setId(s.getId());
            articleDTO.setName(s.getName());
            articleDTO.setContent(s.getContent());
            articleDTO.setDate(s.getDate());
            List<Comment> comments = commentRepository.findAllByArticleId(s.getId());
            articleDTO.setComments(comments);
            articleDTOList.add(articleDTO);
        });
        return articleDTOList;
    }
}
