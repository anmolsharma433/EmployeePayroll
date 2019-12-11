package com.example.employeepayroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.employeepayroll.Android_Ui.Singleton;
import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

public class Addvehicle extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    EditText model, type,palte,make;
    Spinner spinner;
    String vmodel,vtype,vplate,vmake,insurance;
    Switch mySwitch = null;
    Button  btn;
Singleton singleton = Singleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);





        setContentView(R.layout.activity_add_vehicle);
        model = findViewById(R.id.vehiclemodel);
        type = findViewById(R.id.vehicletype);
        palte = findViewById(R.id.vehicleplate);
        make = findViewById(R.id.vehiclemake);

        btn = findViewById(R.id.buttonvehicle);




        spinner = findViewById(R.id.spinnervehicle);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicletype, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(this);



        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();
            }
        });

        mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(this);




       btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        vmodel = model.getText().toString();
        vtype = String.valueOf(type.getText());
        vplate = String.valueOf(palte.getText());

        vmake = make.getText().toString();
        Employee empforvehicle = (Employee) getIntent().getSerializableExtra("empobject1");

            Vehicle vehicle = new Vehicle(vmake, vplate, vmodel, Boolean.valueOf(insurance), vtype);
//        empforvehicle.setMake(vmake);
//        empforvehicle.setInsurance(Boolean.valueOf(insurance));
//        empforvehicle.setModel(vmodel);
//        empforvehicle.setType(vtype);
//        empforvehicle.setPlate(vplate);
        empforvehicle.setmyVehicle(vehicle);



        System.out.println("in vehicle"+vmake+vplate+vmodel);
    }
});



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

