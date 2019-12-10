package com.example.employeepayroll.Employee_Classes.EmployeeType_partTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public  class CommisionBasedPartTime extends PartTime{


    // create variables for stroing values
    @SerializedName("commissionPercent")
    @Expose

    int commisionPercentage;

    // constructor to input all values


    public CommisionBasedPartTime(int employeeId, String name, int age, float rate, int hoursWorked, int commisionPercentage) {
        super(employeeId, name, age, rate, hoursWorked);
        this.commisionPercentage = commisionPercentage;
    }

    public int getCommisionPercentage() {
        return commisionPercentage;
    }

    public void setCommisionPercentage(int commisionPercentage) {
        this.commisionPercentage = commisionPercentage;
    }

    public double calEarnings(){
        return ((getRate()*getHoursWorked()) + ((commisionPercentage/100) *(getRate()*getHoursWorked())));
    }

}

