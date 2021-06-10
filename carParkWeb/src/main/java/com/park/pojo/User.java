package com.park.pojo;

public class User {
    private String uid;
    private String name;
    private String gender;
    private String phone_number;
    private String pwd;
    public User() {
    }

    public User(String uid, String name, String gender, String phone_number,  String pwd) {
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.pwd = pwd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}