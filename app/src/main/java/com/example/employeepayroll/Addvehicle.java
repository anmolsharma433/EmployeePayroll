package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

public class Addvehicle extends AppCompatActivity {
    EditText model, type,palte,make;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

     Employee empforvehicle = getIntent().getParcelableExtra("custvehicleobject");


        setContentView(R.layout.activity_add_vehicle);
        model = findViewById(R.id.vehiclemodel);
        type = findViewById(R.id.vehicletype);
        palte = findViewById(R.id.vehicleplate);
        make = findViewById(R.id.vehiclemake);


        String vmodel = String.valueOf(model.getText());
        String vtype = String.valueOf(type.getText());
        String vplate = String.valueOf(palte.getText());

        String vmake = String.valueOf(make.getText());


        Employee employee = new Employee();



        Vehicle vehicle = new Vehicle(vmake,vplate,vmodel,true,vtype);

        employee.setmyVehicle(vehicle);






    }
}
