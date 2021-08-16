package org.namph.blog.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * author: namph
 * date: 16/08/2021
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;
}
