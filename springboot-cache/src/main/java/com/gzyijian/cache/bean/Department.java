package com.gzyijian.cache.bean;

import java.io.Serializable;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;


    public Department() {
        super();
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
