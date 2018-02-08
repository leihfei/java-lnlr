package com.lnlr.orm;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author 雷洪飞 on 9:18 2018/2/7.
 * desc
 */
@Entity
@Table(name = "lnlr_book")
public class Book {

    // 使用uuid
//    @Id
//    @GenericGenerator(name = "systemUUID",strategy = "uuid")
//    @GeneratedValue(generator = "systemUUID" )
//    private String id;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
