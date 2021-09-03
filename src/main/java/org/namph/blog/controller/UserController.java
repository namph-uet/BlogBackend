package org.namph.blog.controller;

import org.namph.blog.entity.User;
import org.namph.blog.repository.UserRepository;
import org.namph.blog.request.CreateUserRequest;
import org.namph.blog.service.UserService;
import org.namph.blog.util.ResponseBodyUtil;
import org.namph.blog.util.ResponseStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * author: namph
 * date: 16/08/2021
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setFirsName(createUserRequest.getFirsName());
        user.setLastName(createUserRequest.getLastName());
        user.setIntro(createUserRequest.getIntro());
        user.setMobile(createUserRequest.getMobile());
        user.setPasswordHash(userService.hashUserPassword(createUserRequest.getPassword()));
        user.setProfile(createUserRequest.getProfile());
        user.setRegisteredAt(LocalDateTime.now());

        userRepository.saveUser(user);

        ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
        responseBodyUtil.setStatus(ResponseStatusUtil.SUCCESS);
        return ResponseEntity.ok().body(responseBodyUtil);

    }
}
