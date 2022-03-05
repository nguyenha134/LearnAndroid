package com.example.listview;

public class Student {
    private int id;
    private String FullName;
    private String PhoneNum;
    private String Address;

    public Student(){}

    public Student(int id, String fullName, String phoneNum, String address) {
        id=id;
        FullName = fullName;
        PhoneNum = phoneNum;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
