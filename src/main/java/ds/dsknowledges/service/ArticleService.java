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

    Article save(Article article);

    void delete(Long id);

    ArticleDTO findById(Long id);
}
