package com.example.employeepayroll.Employee_Classes.Employee_PartTime;

import com.example.employeepayroll.Employee_Classes.Employee;

import java.io.Serializable;

public class Intern extends Employee implements Serializable {

    // create variables for stroing values
    private String schoolName;

    //constructor to get values
    public Intern(String employeeName, int employeeAge, String schoolName) {
        super(employeeName, employeeAge);
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
