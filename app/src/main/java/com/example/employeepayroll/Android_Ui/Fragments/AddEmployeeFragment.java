package com.example.employeepayroll.Android_Ui.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.PartTime;
import com.example.employeepayroll.R;

public class AddEmployeeFragment extends Fragment {
    EditText id,name,email,Age,model,plate,hoursworked,rate,ratemcommissionPer,school,salary,bonus,commorfixed;
    RadioGroup employeeType,vehicleType;
    CheckBox vehicle,commOrFixed;
    RadioButton car,motorcycle,fullTime,partTime,intern;
    ImageView vehicleImg;
    Button savePayroll;
    LinearLayout ly_partTime,ly_intern,ly_fulltime;
    String empType;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_employee,container,false);
        id  = view.findViewById(R.id.edtId);
        name = view.findViewById(R.id.edtName);
        email = view.findViewById(R.id.etEmail);
        Age = view.findViewById(R.id.edtDob);
        hoursworked = view.findViewById(R.id.edtHours);
        rate = view.findViewById(R.id.edtRate);
        ratemcommissionPer = view.findViewById(R.id.edtCommissionPerOrFixedAmt);
        school = view.findViewById(R.id.edtSchoolName);
        salary = view.findViewById(R.id.edtSalary);
        bonus = view.findViewById(R.id.edtBonus);
        employeeType =view.findViewById(R.id.rgbEmployeeType);
        fullTime = view.findViewById(R.id.rbFulltime);
        partTime = view.findViewById(R.id.rbParttime);
        intern = view.findViewById(R.id.rbIntern);
        commOrFixed = view.findViewById(R.id.chkFixedOrCommission);
        savePayroll = view.findViewById(R.id.btnSavePayroll);
        ly_partTime = view.findViewById(R.id.linear_Part_Time);
        ly_intern =view.findViewById(R.id.linearIntern);
        ly_fulltime = view.findViewById(R.id.linearFulltime);


        //hiding the Fields on startup
        ly_partTime.setVisibility(View.GONE);
        ly_fulltime.setVisibility(View.GONE);
        ly_intern.setVisibility(View.GONE);

        //RadioButton group Employee Type
        employeeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i)
            {
                switch (i)
                {
                    case R.id.rbParttime:
                        ly_partTime.setVisibility(View.VISIBLE);
                        ly_fulltime.setVisibility(View.GONE);
                        ly_intern.setVisibility(View.GONE);
                        empType = "Part Time";
                        break;

                    case R.id.rbIntern:
                        ly_partTime.setVisibility(View.GONE);
                        ly_fulltime.setVisibility(View.GONE);
                        ly_intern.setVisibility(View.VISIBLE);
                        empType = "Intern";
                        break;

                    case R.id.rbFulltime:
                        ly_partTime.setVisibility(View.GONE);
                        ly_fulltime.setVisibility(View.VISIBLE);
                        ly_intern.setVisibility(View.GONE);
                        empType = "Full Time";
                        break;


                }
            }
        });


        //getting the value from fields
        final String empid = String.valueOf(id.getText());
        final String empname = String.valueOf(name.getText());
        String empEmail = String.valueOf(email.getText());
        final String empAge = String.valueOf(Age.getText());
        final String empHours = String.valueOf(hoursworked.getText());
        final String emprate = String.valueOf(rate.getText());
        String emprateCommissionper = String.valueOf(ratemcommissionPer.getText());
        String empschool = String.valueOf(school.getText());
        String empsalary = String.valueOf(salary.getText());
        String empbonus = String.valueOf(bonus.getText());

        savePayroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empType == "Part Time")
                {
                    PartTime partTime = new PartTime(Integer.parseInt(empid),empname,Integer.parseInt(empAge),Integer.parseInt(emprate),Integer.parseInt(empHours));
                }
            }
        });





        return view;
    }
}
