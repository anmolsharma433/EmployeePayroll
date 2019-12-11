package com.example.employeepayroll.Employee_Classes.EmployeeType_partTime;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PartTime extends Employee implements Serializable {


    // create variables for Storing values
    @SerializedName("rate")
    @Expose
    private float rate;
    @SerializedName("hoursWorked")
    @Expose
    private int hoursWorked;


    // constructor to input all values


    public PartTime(int employeeId, String name, int age, String type,float rate, int hoursWorked) {
        super(employeeId, name, age,type);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    protected PartTime() {
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
