package org.namph.blog.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: namph
 * date: 16/08/2021
 */
public class UserService {
    @Autowired
    private SessionFactory sessionFactory;
}
