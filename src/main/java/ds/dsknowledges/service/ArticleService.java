package ds.dsknowledges.service;

import ds.dsknowledges.dto.ArticleDTO;
import ds.dsknowledges.dto.ArticleResponseDTO;
import ds.dsknowledges.model.Article;

public interface ArticleService  {

    /**
     * Returns articles by page.
     *
     * @param page is page number.
     * @return {@link ArticleResponseDTO} object.
     */
    ArticleResponseDTO findAll(int page);

    /**
     * Creates new article.
     *
     * @param article is entity.
     * @return {@link Article} entity.
     */
    Article save(Article article);

    /**
     * Returns article by the given id.
     *
     * @param id is articles's identifier.
     * @return {@link ArticleDTO} object.
     */
    ArticleDTO findById(Long id);

    /**
     * Deletes article by the given id.
     *
     * @param id is article identifier.
     */
    void delete(Long id);
}
