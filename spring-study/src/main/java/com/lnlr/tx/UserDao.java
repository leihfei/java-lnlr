package com.lnlr.tx;

import com.lnlr.base.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 雷洪飞 on 10:06 2018/2/8.
 * desc
 */
public class UserDao {


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book) {
        String sql = "insert into lnlr_book(title,author) VALUES (?,?)";
        jdbcTemplate.update(sql, new Object[]{book.getTitle(), book.getAuthor()});
        System.out.println("save object....");

    }
}
