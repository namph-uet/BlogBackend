package org.namph.blog.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.namph.blog.entity.Meta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MetaRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param meta
     */
    public void saveMeta(Meta meta) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(meta);
        session.getTransaction().commit();
        session.close();
    }
}
