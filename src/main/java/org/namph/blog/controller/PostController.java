package org.namph.blog.controller;

import org.namph.blog.entity.Post;
import org.namph.blog.service.PostService;
import org.namph.blog.util.ResponseBodyUtil;
import org.namph.blog.util.ResponseStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: namph
 * date: 16/08/2021
 */
@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public ResponseEntity getPost(@RequestParam(defaultValue = "0") int id) {
        ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
        Post post = postService.getPost(id);
        responseBodyUtil.setStatus(ResponseStatusUtil.SUCCESS);
        responseBodyUtil.setData(post);
        return ResponseEntity.ok().body(responseBodyUtil);
    }
}
