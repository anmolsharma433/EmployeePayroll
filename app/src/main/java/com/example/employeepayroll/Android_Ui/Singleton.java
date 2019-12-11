package com.example.employeepayroll.Android_Ui;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.CommisionBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.FixedBasedPartTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.FullTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.Intern;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

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

    public  void  create(){
        Intern emp1 = new Intern(1,"Ritik",26,"Intern","ssdp");
        FullTime emp2 = new FullTime(2,"Jagpal",26,"Full Time",200,30);
        CommisionBasedPartTime emp3 = new CommisionBasedPartTime(3,"Rizul",26,"PartTime / Commissioned",23,14,20);
        FixedBasedPartTime emp4 = new FixedBasedPartTime(4,"Kulddep",56,"PartTime / Fixed Amount",20,15,300);


        Vehicle vehicle1= new Vehicle("BMW","KO PB08","S21",true,"CAR");
        Vehicle vehicle2= new Vehicle("Suzuki","MZ Pb09","New",true,"CAR");
        Vehicle vehicle3= new Vehicle("Yamaha","BM PB10","Super",false,"Motorcycle");

        Vehicle vehicle4= new Vehicle("Honda","CX PB11","Ultra",true,"Motorcycle");


        emp1.setmyVehicle(vehicle1);

        emp2.setmyVehicle(vehicle2);

        emp3.setmyVehicle(vehicle3);

        emp4.setmyVehicle(vehicle4);

        addEmployee(emp1);
        addEmployee(emp2);
        addEmployee(emp3);
        addEmployee(emp4);

    }


    public int returnCount()
    {
        return employeeArrayList.size();
    }


}
