package com.example.employeepayroll.Employee_Classes.Employee_PartTime;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Intern extends Employee implements Parcelable {

    // create variables for stroing values
    @SerializedName("schoolName")
    @Expose
    private String schoolName;

    //constructor to get values


    public  Intern()
    {

    }

    public Intern(int employeeId, String name, int age, String type, String schoolName) {
        super(employeeId, name, age, type);
        this.schoolName = schoolName;
    }


    //getter and setter
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double calEarnings()
    {
        return 1000;
    }

}
