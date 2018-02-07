package com.lnlr.base;

/**
 * @author 雷洪飞 on 9:46 2018/2/7.
 * desc
 */
public class BookFactory {

    private static Book books = new Book();

    public static Book createInstance() {
        return books;
    }
}
