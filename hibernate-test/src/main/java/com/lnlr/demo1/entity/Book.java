package com.lnlr.demo1.entity;

import javax.persistence.*;

/**
 * @author 雷洪飞 on 16:56 2018/2/1.
 * desc
 */

@Entity
@Table(name = "hib_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    private String title;


    private String author;


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
