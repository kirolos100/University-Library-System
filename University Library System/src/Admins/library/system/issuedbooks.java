/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admins.library.system;

/**
 *
 * @author Lapshop
 */
public class issuedbooks {
   int procedureid;
   int bookid;
   int studentid;
   boolean returned;

    public issuedbooks() {
    }

    public void setProcedureid(int procedureid) {
        this.procedureid = procedureid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getProcedureid() {
        return procedureid;
    }

    public int getBookid() {
        return bookid;
    }

    public int getStudentid() {
        return studentid;
    }

    public boolean isReturned() {
        return returned;
    }

}
