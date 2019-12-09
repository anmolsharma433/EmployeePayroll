package com.example.employeepayroll.Android_Ui;

import com.example.employeepayroll.Employee_Classes.Employee;

import java.util.ArrayList;

public class Singleton {
    private static Singleton obj;
    
    ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public static Singleton getInstance() {
        if (obj == null) {
            obj = new Singleton();
        }
        return obj;
    }

    public void addEmployee(Employee e) {
        employeeArrayList.add(e);
    }

    public Employee getEmployeeByIndex(int index) {
        if (index < employeeArrayList.size()) {
            return employeeArrayList.get(index);
        }
        return null;
    }

    public ArrayList<Employee> getEmployees() {
        if (employeeArrayList.size() > 0) {
            return employeeArrayList;
        }
        return null;
    }
}
