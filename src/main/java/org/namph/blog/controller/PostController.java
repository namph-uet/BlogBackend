package org.namph.blog.controller;

import org.namph.blog.entity.Post;
import org.namph.blog.repository.PostRepository;
import org.namph.blog.request.PostRequest;
import org.namph.blog.service.PostService;
import org.namph.blog.util.ResponseBodyUtil;
import org.namph.blog.util.ResponseStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * author: namph
 * date: 16/08/2021
 */
@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ResponseEntity getPost(@RequestParam(defaultValue = "0") int id) {
        ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
        Post post = postService.getPost(id);
        responseBodyUtil.setStatus(ResponseStatusUtil.SUCCESS);
        responseBodyUtil.setData(post);
        return ResponseEntity.ok().body(responseBodyUtil);
    }

    @PostMapping
    public ResponseEntity newPost(@Valid @RequestBody PostRequest postRequest) {
        Post post = new Post();

        post.setAuthorId(postRequest.getAuthorId());
        post.setContent(postRequest.getContent());
        post.setMetaTitle(postRequest.getMetaTitle());
        post.setSlug(postRequest.getSlug());
        post.setTitle(postRequest.getTitle());
        post.setSummary(postRequest.getTitle());

        post.setCreateAt(LocalDateTime.now());
        post.setUpdateAt(LocalDateTime.now());
        post.setPublishedAt(LocalDateTime.now());
        post.setPublished(true);

        int result = postRepository.saveNewPost(post);
        ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
        HttpStatus httpStatus;
        if(result > 0) {
            responseBodyUtil.setStatus(ResponseStatusUtil.SUCCESS);
            httpStatus = HttpStatus.OK;
        } else {
            responseBodyUtil.setStatus(ResponseStatusUtil.FAIL);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        responseBodyUtil.setStatus(ResponseStatusUtil.SUCCESS);

        return ResponseEntity.status(httpStatus).body(responseBodyUtil);
    }
}
