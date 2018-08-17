package ds.dsknowledges.controller;

import ds.dsknowledges.dto.ArticleDTO;
import ds.dsknowledges.dto.ArticleResponseDTO;
import ds.dsknowledges.model.Article;
import ds.dsknowledges.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * Returns articles by page.
     *
     * @param page is page number.
     * @return {@link ArticleResponseDTO} object.
     */
    @GetMapping("/findAll/{page}")
    public ResponseEntity<ArticleResponseDTO> findAll(@PathVariable("page") int page) {
        ArticleResponseDTO articleResponseDTO = articleService.findAll(page);
        return new ResponseEntity<>(articleResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> save(@RequestBody Article article) {
        Article savedArticle = articleService.save(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        articleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ArticleDTO> findById(@PathVariable("id") Long id) {
        ArticleDTO article = articleService.findById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
