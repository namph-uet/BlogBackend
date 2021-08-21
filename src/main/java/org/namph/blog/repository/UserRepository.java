package org.namph.blog.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.namph.blog.entity.Post;
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

    /**
     *
     * @param id
     * @return
     */
    public Post findById(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Post.class, id);
    }
}
