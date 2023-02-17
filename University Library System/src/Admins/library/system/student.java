/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admins.library.system;

/**
 *
 * @author Lapshop
 */



public class student {
    int id;
    String name;
    String email;
    String mobile;
    int year;int month; int day;
    String birthday;

    public student() {
    }

    public student(int id, String name, String email, String mobile, String birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.birthday=birthday;


    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }


}
