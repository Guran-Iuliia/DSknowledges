package ds.dsknowledges.service;

import ds.dsknowledges.model.Comment;

public interface CommentService {

    /**
     * Creates comment entity.
     *
     * @param comment is entity.
     * @return saved {@link Comment} entity.
     */
    Comment save(Comment comment);

    /**
     * Deletes comments entity.
     *
     * @param id is comment's identifier.
     */
    void delete(Long id);
}
