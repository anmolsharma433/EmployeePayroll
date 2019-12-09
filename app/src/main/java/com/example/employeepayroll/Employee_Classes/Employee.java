package com.example.employeepayroll.Employee_Classes;

import com.example.employeepayroll.Vehicle_Classes.Vehicle;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Employee{

    //declare variables
    private String name;
    private int age;
    private String employee;
    private int employeeId;
    private String vehicleType;
    public Vehicle vehicle;

    //constructor


    public Employee(String name,int age) {
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double calEarnings();
    {

    }
}
