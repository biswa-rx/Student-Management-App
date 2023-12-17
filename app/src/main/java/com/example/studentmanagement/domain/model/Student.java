package com.example.studentmanagement.domain.model;

public class Student {
    String name;
    int roll_no;
    String password;

    String id;


    public Student(String id, String name, int roll_no, String password) {
        this.name = name;
        this.roll_no = roll_no;
        this.password = password;
        this.id = id;
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

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
