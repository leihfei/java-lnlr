package com.lnlr.tx;

import com.lnlr.base.Book;

/**
 * @author 雷洪飞 on 10:14 2018/2/8.
 * desc
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(Book book) {
        System.out.println("service 新增对象");
        userDao.save(book);
        // 抛出异常
        int i = 1 / 0;

        userDao.save(book);
    }
}
