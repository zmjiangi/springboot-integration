package com.gzyijian.cache.bean;

import java.io.Serializable;

/**
 * @author zmjiangi
 * @date 2019-6-19
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String lastName;

    private String email;

    /**
     * 性别 1男  0女
     */
    private Integer gender;

    private Integer departmentId;


    public Employee() {
        super();
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer departmentId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
