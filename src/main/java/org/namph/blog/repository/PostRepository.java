package org.namph.blog.repository;

import org.hibernate.*;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.namph.blog.dto.PostIntroDto;
import org.namph.blog.entity.Post;
import org.namph.blog.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        sql.append("SElECT p.id, p.summary, us.last_name, us.first_name,");
        sql.append(" p.published_at, p.title, ARRAY_TO_STRING(ARRAY_AGG(t.tag_name),'&') as tags,");
        sql.append(" p.image_intro");
        sql.append(" FROM post as p LEFT JOIN post_tag as pts ON p.id = pts.post_id");
        sql.append(" LEFT JOIN tag as t ON pts.tag_id = t.id");
        sql.append(" LEFT JOIN meta as pm ON p.id = pm.post_id");
        sql.append(" LEFT JOIN \"user\" as us ON us.id = p.author_id");
        sql.append(" WHERE p.published = true");
        sql.append(" GROUP BY p.id, us.id, pm.post_id");

        Query query = session.createSQLQuery(sql.toString());
        List<Map> result = query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();

        List dtoResult = new ArrayList();
        for (Map e : result) {
            PostIntroDto dtoObject = new PostIntroDto(
                    Integer.parseInt(e.get("id").toString()),
                    e.get("summary").toString(),
                    e.get("last_name").toString(),
                    e.get("first_name").toString(),
                    e.get("published_at").toString(),
                    e.get("title").toString(),
                    e.get("tags").toString(),
                    CommonUtil.isNull(e.get("image_intro")) ? "" : e.get("image_intro").toString()
            );
            dtoResult.add(dtoObject);
        }
        return dtoResult;
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

    /**
     *
     * @return
     */
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

    public int findIdByCreateAt(LocalDateTime time) {
        Session session = this.sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder();
        sql.append("SElECT id ");
        sql.append(" FROM post");
        sql.append(" WHERE create_at = :value");

        SQLQuery query = session.createSQLQuery(sql.toString());
        query.setParameter("value", time);

        return query.getFirstResult();
    }
}
