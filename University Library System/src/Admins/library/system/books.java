/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admins.library.system;

/**
 *
 * @author Lapshop
 */
public class books extends issuedbooks {
    int id;
    String bookname;
    String authorname;
    int available;
    int issue;


    public books() {
    }



    public void setIdb(int id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getIdb() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public int getAvailable() {
        return available;
    }

    public int getIssue() {
        return issue;
    }


}
