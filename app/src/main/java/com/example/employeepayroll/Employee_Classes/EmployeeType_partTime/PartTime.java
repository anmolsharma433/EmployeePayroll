package com.example.employeepayroll.Employee_Classes.EmployeeType_partTime;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class PartTime extends Employee {


    // create variables for Storing values
    @SerializedName("rate")
    @Expose
    private float rate;
    @SerializedName("hoursWorked")
    @Expose
    private int hoursWorked;


    // constructor to input all values


    public PartTime(int employeeId, String name, int age, float rate, int hoursWorked) {
        super(employeeId, name, age);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public float getRate() {
        return (float) rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }





}
