package casemodules4.service;

import casemodules4.model.Post;

public interface IPostService extends IGeneralService<Post> {
    Iterable<Post> findAllByHasTag(String hasTag);
}
