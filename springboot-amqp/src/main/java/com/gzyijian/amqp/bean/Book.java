package com.gzyijian.amqp.bean;

import java.io.Serializable;

/**
 * @author zmjiangi
 * @date 2019-6-
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String author;

    public Book() {
        super();
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
