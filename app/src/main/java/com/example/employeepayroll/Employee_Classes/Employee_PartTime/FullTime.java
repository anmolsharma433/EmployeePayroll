package com.example.employeepayroll.Employee_Classes.Employee_PartTime;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.FixedBasedPartTime;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public  class FullTime extends Employee implements  Serializable {

    // create variables for stroing values
    @SerializedName("salary")
    @Expose

    int salary;
    @SerializedName("bonus")
    @Expose
    int bonus;

    // constructor to input all values
    public FullTime()
    {

    }



    public FullTime(int employeeId, String name, int age, String type, int salary, int bonus) {
        super(employeeId, name, age, type);
        this.salary = salary;
        this.bonus = bonus;
    }

    //getter and setter
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = (int) salary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = (int) bonus;
    }

    public double calEarnings()
    {
        return (getSalary() + getBonus());
    }


}
