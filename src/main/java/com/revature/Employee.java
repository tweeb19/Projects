package com.revature;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "salary")
    private int salary;
    //private String gender;

    public Employee() {
    }


    public Employee(int emp_id, String name, String title, int salary) {

        this.emp_id = emp_id;
        this.name = name;
        this.title = title;
        this.salary = salary;
        //this.gender = gender;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

