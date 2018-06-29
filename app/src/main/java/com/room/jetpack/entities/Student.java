package com.room.jetpack.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

@Entity(tableName = "student_registration")
public class Student implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "studentId")
    public int id;

    @ColumnInfo(name = "student_name")
    private String studentName;

    @ColumnInfo(name = "father_name")
    private String fatherName;

    @ColumnInfo(name = "mother_name")
    private String motherName;

    @ColumnInfo(name = "dob")
    private String dob;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "course")
    private String course;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone")
    private String phone;

    @NonNull
    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
