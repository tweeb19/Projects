package com.revature.project2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    private int id;
    private String name;
    private String uname;
    private String pword;
    private String email;
    private int age;
}
