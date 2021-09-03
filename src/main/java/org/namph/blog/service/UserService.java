package org.namph.blog.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * author: namph
 * date: 16/08/2021
 */
@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String hashUserPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
