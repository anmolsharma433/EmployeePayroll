package com.example.employeepayroll.Vehicle_Classes;

import java.io.Serializable;

public class Motorcycle extends Vehicle implements Serializable {
    float enginePower;
    float topSpeed;

    public Motorcycle()
    {
        super();
    }

    public Motorcycle(String company, String plate, String colour, int year, float enginePower, float topSpeed) {
        super(company, plate, colour, year);
        this.enginePower = enginePower;
        this.topSpeed = topSpeed;
    }

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }
}
