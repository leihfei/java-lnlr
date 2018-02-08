package com.lnlr.orm;

import org.hibernate.SessionFactory;

/**
 * @author 雷洪飞 on 10:06 2018/2/8.
 * desc
 */
public class UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }
}
