package com.lnlr.aop;


import com.lnlr.base.Book;
import com.lnlr.base.BookFactory;
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
        ac = new ClassPathXmlApplicationContext("spring-aop.xml");
    }

    @Test
    public void base() {
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.save();
    }
}
