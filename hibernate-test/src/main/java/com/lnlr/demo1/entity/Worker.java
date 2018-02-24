package com.lnlr.demo1.entity;

/**
 * @author 雷洪飞 on 11:55 2018/2/23.
 * desc
 */

public class Worker {
    private int id;

    private String name;

    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
