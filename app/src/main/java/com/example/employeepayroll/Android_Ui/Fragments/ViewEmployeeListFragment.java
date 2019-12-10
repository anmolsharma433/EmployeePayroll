package com.example.employeepayroll.Android_Ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class ViewEmployeeListFragment extends Fragment {
    EditText id,name,email,dob,model,plate,hoursworked,rate,ratemcommissionPer,school,salary,bonus,commorfixed;
    RadioGroup employeeType,vehicleType;
    CheckBox vehicle,commOrFixed;
    RadioButton car,motorcycle,fullTime,partTime,intern;
    ImageView vehicleImg;
    Button savePayroll;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_employee,container,false);






        return view;
    }
}
