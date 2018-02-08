package com.lnlr.tx;


import com.lnlr.base.Book;
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
        ac = new ClassPathXmlApplicationContext("spring-tx.xml");
    }

    @Test
    public void base() {
        UserService userService = ac.getBean("userService", UserService.class);
        Book book = new Book();
        book.setAuthor("雷洪飞");
        book.setTitle("测试事务....");
        userService.save(book);
    }
}
