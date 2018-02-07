package com.lnlr.base;


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
        ac = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void base() {
        Book book = ac.getBean("book", Book.class);
        System.out.println(book);
        System.out.println(book.getAuthor());

        // 使用c命名空间
        Book cBook = ac.getBean("cBook", Book.class);
        System.out.println(cBook);
        System.out.println(cBook.getAuthor());

//        Book book1 = ac.getBean("book1", Book.class);
//        Book book4 = ac.getBean("book4", Book.class);
//        System.out.println(book1);
//        System.out.println(book4);

        System.out.println(BookFactory.createInstance().getAuthor());
    }
}
