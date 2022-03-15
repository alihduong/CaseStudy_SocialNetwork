package casemodules4.service;

import casemodules4.model.LikePost;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ILikePostService extends IGeneralService<LikePost> {
    Optional<LikePost> findById_PostAndId_User(Long id_post, Long id_user);

    Long countLikeCommentById_Post(Long id_post);

    void deleteAllByPost_Id(Long id_post);

}
