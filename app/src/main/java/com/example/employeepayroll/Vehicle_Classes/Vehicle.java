package com.example.employeepayroll.Vehicle_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public abstract class Vehicle  {
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("plate")
    @Expose
    private String plate;
    @SerializedName("model")
    @Expose
    private  String model;
    @SerializedName("insurance")
    @Expose
    private  boolean insurance;
    @SerializedName("type")
    @Expose
    private String type;

    public Vehicle(String make, String plate, String model, boolean insurance, String type) {
        this.make = make;
        this.plate = plate;
        this.model = model;
        this.insurance = insurance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }




}
