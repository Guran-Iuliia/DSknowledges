package ds.dsknowledges.service;

import ds.dsknowledges.model.Comment;

public interface CommentService {

    Comment save(Comment comment);

    void delete(Long id);
}
