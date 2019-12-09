package com.example.employeepayroll.Employee_Classes.EmployeeType_partTime;

import java.io.Serializable;

public final class CommisionBasedPartTime extends PartTime implements Serializable {


    // create variables for stroing values

    int commisionPercentage;

    // constructor to input all values


    public CommisionBasedPartTime(String employeeName, int employeeAge, float rate, int hoursWorked, int commisionPercentage) {
        super(employeeName, employeeAge, rate, hoursWorked);
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

