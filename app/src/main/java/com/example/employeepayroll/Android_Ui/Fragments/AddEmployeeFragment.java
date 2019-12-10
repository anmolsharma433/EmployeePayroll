package com.example.employeepayroll.Android_Ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeepayroll.R;

public class AddEmployeeFragment extends Fragment {
    EditText id,name,email,dob,model,plate,hoursworked,ratemcommissionPer,school,salary,bonus,commorfixed;
    RadioGroup employeeType,vehicleType;
    CheckBox vehicle,commOrFixed;
    RadioButton car,motorcycle,fullTime,partTime,intern;
    ImageView vehicleImg;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_employee,container,false);
        id  = view.findViewById(R.id.edtId);
        name = view.findViewById(R.id.edtName);
        email = view.findViewById(R.id.etEmail);
        dob = view.findViewById(R.id.edtDob);
        model =view.findViewById(R.id.edtModel);
        plate = view.findViewById(R.id.edtPlate);
        hoursworked = view.findViewById(R.id.edtHours);
        ratemcommissionPer = view.findViewById(R.id.edtRate);
        school = view.findViewById(R.id.edtSchoolName);
        salary = view.findViewById(R.id.edtSalary);
        bonus = view.findViewById(R.id.edtBonus);
        vehicleType = view.findViewById(R.id.rgbVehicle);
        employeeType =view.findViewById(R.id.rgbEmployeeType);
        vehicle = view.findViewById(R.id.chkVehicle);
        vehicleImg = view.findViewById(R.id.vehicle_Image);
        car = view.findViewById(R.id.rbCar);
        motorcycle = view.findViewById(R.id.rbMotorcycle);
        commorfixed = view.findViewById(R.id.edtCommissionPerOrFixedAmt);
        fullTime = view.findViewById(R.id.rbFulltime);
        partTime = view.findViewById(R.id.rbParttime);
        intern = view.findViewById(R.id.rbIntern);
        commOrFixed = view.findViewById(R.id.chkFixedOrCommission);

        //hiding the Fields on startup
        vehicleType.setVisibility(View.GONE);
        model.setVisibility(View.GONE);
        plate.setVisibility(View.GONE);
        hoursworked.setVisibility(View.GONE);
        ratemcommissionPer.setVisibility(View.GONE);
        school.setVisibility(View.GONE);
        salary.setVisibility(View.GONE);
        bonus.setVisibility(View.GONE);
        vehicleImg.setVisibility(View.GONE);
        commOrFixed.setVisibility(View.GONE);
        commorfixed.setVisibility(View.GONE);

        //Showing the Vehicle properties on Vehicle Checkbox
        vehicle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(vehicle.isChecked())
                {
                    vehicleType.setVisibility(View.VISIBLE);
                    model.setVisibility(View.VISIBLE);
                    plate.setVisibility(View.VISIBLE);
                    vehicleImg.setVisibility(View.VISIBLE);
                }
                else
                {
                    vehicleType.setVisibility(View.GONE);
                    model.setVisibility(View.GONE);
                    plate.setVisibility(View.GONE);
                    vehicleImg.setVisibility(View.GONE);

                }

            }
        });




        return view;
    }
}
