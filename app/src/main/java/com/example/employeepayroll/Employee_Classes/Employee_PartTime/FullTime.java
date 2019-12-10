package com.example.employeepayroll.Employee_Classes.Employee_PartTime;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class FullTime extends Employee implements Serializable {

    // create variables for stroing values
    @SerializedName("salary")
    @Expose

    int salary;
    @SerializedName("bonus")
    @Expose
    int bonus;

    // constructor to input all values


    public FullTime(int employeeId, String name, int age, int salary, int bonus) {
        super(employeeId, name, age);
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
