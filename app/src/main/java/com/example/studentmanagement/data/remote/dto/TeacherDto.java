package com.example.studentmanagement.data.remote.dto;


import com.google.gson.annotations.SerializedName;

public class TeacherDto {
    String name;
    int redg_no;
    String password;

    @SerializedName("_id")
    String id;


    public TeacherDto(String id, String name, int redg_no, String password) {
        this.name = name;
        this.redg_no = redg_no;
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

    public int getRedg_no() {
        return redg_no;
    }

    public void setRedg_no(int roll_no) {
        this.redg_no = roll_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
