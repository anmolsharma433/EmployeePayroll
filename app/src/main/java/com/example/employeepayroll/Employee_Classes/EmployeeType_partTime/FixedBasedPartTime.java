package com.example.employeepayroll.Employee_Classes.EmployeeType_partTime;

import android.util.SparseIntArray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public  class FixedBasedPartTime extends PartTime implements  Serializable  {

    // create variables for stroing values
    @SerializedName("fixedAmount")
    @Expose
    int fixedAmount;

    public  FixedBasedPartTime(){

    }

    public FixedBasedPartTime(int employeeId, String name, int age, String type,float rate, int hoursWorked, int fixedAmount) {
        super(employeeId, name, age,type, rate, hoursWorked);
        this.fixedAmount = fixedAmount;
    }

    // getter and setter

    public int getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(int fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    // constructor to input all values




    public double calEarnings()
    {
        return ((getRate()*getHoursWorked()) + getFixedAmount() + (getRate()*getHoursWorked()));
    }
}

