package com.lnlr.base;

/**
 * @author 雷洪飞 on 9:18 2018/2/7.
 * desc
 */
public class Book {
    private int id;

    private String title;

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
