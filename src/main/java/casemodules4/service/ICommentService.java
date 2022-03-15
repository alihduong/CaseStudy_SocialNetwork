package casemodules4.service;

import casemodules4.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface ICommentService extends IGeneralService<Comment> {
    Iterable<Comment> findAllByPost_Id(Long id);
}
