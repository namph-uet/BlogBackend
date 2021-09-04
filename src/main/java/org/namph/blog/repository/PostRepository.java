package org.namph.blog.repository;

import org.hibernate.*;
import org.namph.blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: namph
 * date: 16/08/2021
 */
@Repository
public class PostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param id
     * @return
     */
    public Post findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Post.class, id);
    }


    /**
     *
     * @return
     */
    public List getAllPostIntro() {
        Session session = this.sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder();

        sql.append("SElECT p.id, p.meta_title, p.summary, p.published, p.published_at, p.title,");
        sql.append(" us.first_name, us.last_name, t.tag_name");
        sql.append(" FROM post as p LEFT JOIN post_tag as pts ON p.id = pts.post_id");
        sql.append(" LEFT JOIN tag as t ON pts.tag_id = t.id");
        sql.append(" LEFT JOIN meta as pm ON p.id = pm.post_id");
        sql.append(" LEFT JOIN \"user\" as us ON us.id = p.author_id");

        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List resilt = query.list();
        return resilt;
    }

    /**
     *
     * @param post
     * @return
     */
    public int saveNewPost(Post post) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
        return 1;
    }

    public List getAllPostOrderById() {
        Session session = this.sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder();

        sql.append("SElECT * ");
        sql.append("FROM post ");
        sql.append("ORDER BY id ASC");

        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.list();
    }
}
