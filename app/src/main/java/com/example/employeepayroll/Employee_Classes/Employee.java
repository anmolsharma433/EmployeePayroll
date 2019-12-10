package com.example.employeepayroll.Employee_Classes;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.employeepayroll.Vehicle_Classes.Vehicle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@SuppressLint("ParcelCreator")

public  class Employee implements Parcelable {

    //declare variables
    @SerializedName("id")
    @Expose
    private int employeeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vehicle")
    @Expose
    public List<Vehicle> vehicle = new ArrayList<Vehicle>();



    protected Employee(Parcel in) {
        employeeId = in.readInt();
        name = in.readString();
        age = in.readInt();
        type = in.readString();
        vehicle = in.createTypedArrayList(Vehicle.CREATOR);
    }

    public Employee() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(employeeId);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(type);
        dest.writeTypedList(vehicle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //constructor

    public Employee(int employeeId, String name, int age, String type) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.type = type;
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
//        if(vehicle == null)
//        {
//          vehicle = new ArrayList<Vehicle>();
//        }
        this.vehicle.add(vehicle);
    }

    public  double calEarnings()
    {
   return 0.00;
    }
}
