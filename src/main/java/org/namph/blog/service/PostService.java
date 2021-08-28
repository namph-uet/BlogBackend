package org.namph.blog.service;

import org.namph.blog.entity.Post;
import org.namph.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: namph
 * date: 16/08/2021
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post getPost(int id) {
        return postRepository.findById(id);
    }
}
