package ds.dsknowledges.dto;

import ds.dsknowledges.model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleDTO {
    private Long id;
    private String name;
    private String content;
    private String date;
    private List<Comment> comments;
}
