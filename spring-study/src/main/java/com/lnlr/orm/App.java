package com.lnlr.orm;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 雷洪飞 on 9:16 2018/2/7.
 * desc
 */
public class App {

    private ApplicationContext ac;

    @Before
    public void befor() {
        ac = new ClassPathXmlApplicationContext("spring-orm.xml");
    }

    @Test
    public void base() {
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        Book book = new Book();
        book.setTitle("测试orm");
        book.setAuthor("张三");
        userDao.save(book);
    }
}
