/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

/**
 *
 * @author eliasc
 */
public class Student {
    
    private int studentID;
    private int studentNo;
    private String name;
    private String surname;
    private String gender;
    private Address address;

    public Student() {
    }

    public Student(int studentID, int studentNo, String name, String surname, String gender, Address address) {
        this.studentID = studentID;
        this.studentNo = studentNo;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
    
}
