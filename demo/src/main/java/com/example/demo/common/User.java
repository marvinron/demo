package com.example.demo.common;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {

    private static final long serialVersionUID = 7198420845927323855L;
    /**
     * ID
     */
    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * Date
     */
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
