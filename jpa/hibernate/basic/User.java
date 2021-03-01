package com.practice.jpaTest;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="USER_NO")
    private int no;
    @Column(name="USER_ID")
    private String id;
    @Column(name="USER_PASSWORD")
    private String password;
    @Column(name="USER_NAME")
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
