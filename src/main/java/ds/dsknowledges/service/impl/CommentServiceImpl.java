package ds.dsknowledges.service.impl;

import ds.dsknowledges.model.Comment;
import ds.dsknowledges.repository.CommentRepository;
import ds.dsknowledges.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        Assert.notNull(comment, "comment is null");
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "id is null");
        commentRepository.delete(id);
    }
}
