package org.namph.blog.repository;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public Post findById(String id) {
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

        sql.append("SElECT p.meta_title, p.summary, p.published, p.published_at \n");
        sql.append("FROM post as p LEFT JOIN post_tags as pts ON p.id = pts.post_id\n");
        sql.append("INNER JOIN tag as t ON pts.tags_id = t.id\n");
        sql.append("INNER JOIN post_metas as pm ON p.id = pm.post_id\n");
        sql.append("INNER JOIN \"user\" as us ON us.id = p.author_id");

        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        return query.list();
    }

    /**
     *
     * @param post
     * @return
     */
    public int saveNewPost(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(post);
        return 1;
    }
}
