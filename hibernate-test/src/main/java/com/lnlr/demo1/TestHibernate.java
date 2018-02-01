package com.lnlr.demo1;

import com.lnlr.demo1.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * @author 雷洪飞 on 16:43 2018/2/1.
 * desc
 */
public class TestHibernate {

    @Test
    public void test() {
        final StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(build).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // 一顿操作
        Book book = new Book();
        book.setAuthor("雷洪飞");
        book.setTitle("测试...");
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
}
