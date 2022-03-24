package com.revature.project2.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    @Column(name = "user_age")
    private int age;
    @Column(name = "uname")
    private String username;
    @Column(name = "pword")
    private String password;
}

