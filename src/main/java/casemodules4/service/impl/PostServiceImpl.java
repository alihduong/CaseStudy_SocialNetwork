package casemodules4.service.impl;

import casemodules4.model.Comment;
import casemodules4.model.Post;
import casemodules4.repository.IPostRepository;
import casemodules4.service.ICommentService;
import casemodules4.service.ILikePostService;
import casemodules4.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private ILikePostService iLikePostService;

    @Override
    public Iterable<Post> findAll() {
        return iPostRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return iPostRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return iPostRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        Iterable<Comment> comments = iCommentService.findAllByPost_Id(id);
        for (Comment comment : comments) {
            iCommentService.remove(comment.getIdComment());
        }
        iLikePostService.deleteAllByPost_Id(id);
        iPostRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllByHasTag(String hasTag) {
        return iPostRepository.findAllByContentContaining(hasTag);
    }
}
