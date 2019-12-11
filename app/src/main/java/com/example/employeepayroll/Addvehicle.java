package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

public class Addvehicle extends AppCompatActivity {
    EditText model, type,palte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Employee empforvehicle = getIntent().getParcelableExtra("custvehicleobject");

//
//        setContentView(R.layout.activity_addvehicle);
//        model = findViewById(R.id.vehiclemodel);
//        type = findViewById(R.id.vehicleType);
//        palte = findViewById(R.id.vehicleplate);

        String vmodel = String.valueOf(model.getText());
        String vtype = String.valueOf(type.getText());
        String vplate = String.valueOf(palte.getText());

        Employee employee = new Employee();



        Vehicle vehicle = new Vehicle();

        empforvehicle.setmyVehicle(vehicle);

//
//        employee.setmyVehicle();



    }
}
