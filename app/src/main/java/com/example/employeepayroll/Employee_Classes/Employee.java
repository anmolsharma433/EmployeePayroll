package com.example.employeepayroll.Employee_Classes;

import com.example.employeepayroll.Vehicle_Classes.Vehicle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public  class Employee{

    //declare variables
    @SerializedName("employeeid")
    @Expose
    private int employeeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private int age;

    public List<Vehicle> vehicle;

    //constructor

    public Employee(int employeeId, String name, int age) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
    }


    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public void setmyVehicle(Vehicle vehicle) {
        this.vehicle.add(vehicle);
    }

    public  double calEarnings()
    {
   return 0.00;
    }
}
