package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

public class Addvehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    EditText model, type,palte,make;
    Spinner spinner;
    String vmodel,vtype,vplate,vmake,insurance;
    Switch mySwitch = null;
    Employee empforvehicle = (Employee) getIntent().getSerializableExtra("empobject1");


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
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(this);



        type.setOnClickListener(this);

        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(this);








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

        Vehicle vehicle = new Vehicle(vmake,vplate,vmodel,Boolean.valueOf(insurance),vtype);


        empforvehicle.setmyVehicle(vehicle);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            if (isChecked) {
                insurance = mySwitch.getText().toString();
                // do something when check is selected
            } else {
                insurance = mySwitch.getText().toString();
                //do something when unchecked
            }
        }
    }

