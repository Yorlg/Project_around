package com.codeing.tabuser.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yorlg
 * @data 2021-12-28
 * @apiNote
 */

@Data
@Table(name = "tab_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
