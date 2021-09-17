package org.namph.blog.service;

import org.namph.blog.entity.Post;
import org.namph.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: namph
 * date: 16/08/2021
 */
@Service
public class PostService {
    private static final String IMG_SRC_REGEX = "<img src=\\\"([^\\\"]+)";
    @Autowired
    private PostRepository postRepository;

    public Post getPost(int id) {
        return postRepository.findById(id);
    }

    /**
     * find image url in post
     * @param postContent
     * @return
     */
    public String findImageUrl(String postContent) {
        String result = "";

        final Pattern pattern = Pattern.compile(IMG_SRC_REGEX);
        final Matcher matcher = pattern.matcher(postContent);

        if (matcher.find()) {
            result = matcher.group(1);
        }

        return result;
    }
}
