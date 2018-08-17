package ds.dsknowledges.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticleResponseDTO {
    private List<ArticleDTO> articles;
    private long total;
}
