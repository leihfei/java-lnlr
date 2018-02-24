package com.lnlr.demo1;

import com.lnlr.demo1.entity.Book;
import com.lnlr.demo1.entity.Project;
import com.lnlr.demo1.entity.Worker;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @author 雷洪飞 on 16:43 2018/2/1.
 * desc
 */
public class TestHibernate {
    SessionFactory sessionFactory = null;

    @Before
    public void befor() {
        final StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(build).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    @Test
    public void test() {
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

    @Test
    public void test_orm() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Project project = new Project();
        project.setProName("项目1");

        Worker worker = new Worker();
        worker.setName("李四");
        worker.setProject(project);

        project.getWorkers().add(worker);

        project.setWorkers(project.getWorkers());

        session.save(project);
        session.save(worker);


        session.close();
    }


    @Test
    public void list() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Project ");
        List<Project> list = query.list();


        for (Project p : list) {
            System.out.println(p.getWorkers());
        }
        /**
         * 优化hibernate:
         *  1. 使用懒加载
         *  2. 数据抓取策略
         *  3. 缓存策略
         *  3. hql优化
         */

        ScrollableResults scroll = query.scroll();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void iterator() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Project ");

        Iterator<Project>  iterate = query.iterate();

        while (iterate.hasNext()) {

            Project customer = iterate.next();

            System.out.println(customer.getProName());

        }

        session.getTransaction().commit();
        session.close();
    }
}
