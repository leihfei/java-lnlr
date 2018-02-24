package com.lnlr.demo1.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 雷洪飞 on 11:54 2018/2/23.
 * desc
 */

public class Project {

    private int id;

    private String proName;

    private Set<Worker> workers = new HashSet<Worker>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}
