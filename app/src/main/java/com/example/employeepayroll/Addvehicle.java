package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

public class Addvehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText model, type,palte,make;
    Spinner spinner;
    String vmodel,vtype,vplate,vmake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);





        setContentView(R.layout.activity_add_vehicle);
        model = findViewById(R.id.vehiclemodel);
        type = findViewById(R.id.vehicletype);
        palte = findViewById(R.id.vehicleplate);
        make = findViewById(R.id.vehiclemake);


         vmodel = String.valueOf(model.getText());
         vtype = String.valueOf(type.getText());
         vplate = String.valueOf(palte.getText());

         vmake = String.valueOf(make.getText());


        spinner = findViewById(R.id.spinnervehicle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicletype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(this);



        type.setOnClickListener(this);










    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textposition = parent.getSelectedItem().toString();
        type.setText(textposition);
        // Toast.makeText(view.getContext(),textposition,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        type.setText("");

    }

    @Override
    public void onClick(View v) {
        Employee empforvehicle = (Employee) getIntent().getSerializableExtra("empobject1");


        Vehicle vehicle = new Vehicle(vmake,vplate,vmodel,true,vtype);

        empforvehicle.setmyVehicle(vehicle);

    }
}
