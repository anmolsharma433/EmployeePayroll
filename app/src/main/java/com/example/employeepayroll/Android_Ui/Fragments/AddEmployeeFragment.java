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

import com.example.employeepayroll.Android_Ui.Singleton;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.CommisionBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.FixedBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.PartTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.FullTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.Intern;
import com.example.employeepayroll.R;

public class AddEmployeeFragment extends Fragment {
    EditText id,name,email,Age,commissionBased,fixedBased,hoursworked,rate,ratemcommissionPer,school,salary,bonus;
    RadioGroup employeeType,partTimeType;
    CheckBox vehicle,commOrFixed;
    RadioButton comBased,fixBased,fullTime,partTime,intern;
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
        school = view.findViewById(R.id.edtSchoolName);
        salary = view.findViewById(R.id.edtSalary);
        bonus = view.findViewById(R.id.edtBonus);
        employeeType =view.findViewById(R.id.rgbEmployeeType);
        fullTime = view.findViewById(R.id.rbFulltime);

        intern = view.findViewById(R.id.rbIntern);
        partTimeType = view.findViewById(R.id.part_Time_check);
        comBased = view.findViewById(R.id.rbcommission_Based);
        fixBased = view.findViewById(R.id.rbfixed_Based);
        savePayroll = view.findViewById(R.id.btnSavePayroll);
        ly_partTime = view.findViewById(R.id.linear_Part_Time);
        ly_intern =view.findViewById(R.id.linearIntern);
        ly_fulltime = view.findViewById(R.id.linearFulltime);
        //partTime editText
        commissionBased = view.findViewById(R.id.commission_Based);
        fixedBased =view.findViewById(R.id.fixed_Based);

        //hiding the Fields on startup
        ly_partTime.setVisibility(View.GONE);
        ly_fulltime.setVisibility(View.GONE);
        ly_intern.setVisibility(View.GONE);
        commissionBased.setVisibility(View.GONE);
        fixedBased.setVisibility(View.GONE);


        //RadioButton group Employee Type
        employeeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i)
            {
                switch (i)
                {
                    case R.id.rbfixed_Based:
                        empType = "Fixed Based";
                        fixedBased.setVisibility(View.VISIBLE);
                        ly_partTime.setVisibility(View.VISIBLE);
                        ly_fulltime.setVisibility(View.GONE);
                        ly_intern.setVisibility(View.GONE);
                        commissionBased.setVisibility(View.GONE);
                        break;

                    case R.id.rbcommission_Based:
                        empType = "Commission Based";
                        commissionBased.setVisibility(View.VISIBLE);
                        ly_partTime.setVisibility(View.VISIBLE);
                        ly_fulltime.setVisibility(View.GONE);
                        ly_intern.setVisibility(View.GONE);
                        fixedBased.setVisibility(View.GONE);
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
        final String empschool = String.valueOf(school.getText());
        final String empsalary = String.valueOf(salary.getText());
        final String empbonus = String.valueOf(bonus.getText());
        final String empFixedBased = String.valueOf(fixedBased.getText());
        final String empCommissionBased = String.valueOf(commissionBased.getText());

        savePayroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(empType == "Fixed Based")
                {
                    FixedBasedPartTime  fixedBasedPartTime = new FixedBasedPartTime(Integer.parseInt(empid),empname,Integer.parseInt(empAge),empType,Float.parseFloat(emprate),Integer.parseInt(empHours),Integer.parseInt(empFixedBased));
                    Singleton.getInstance().addEmployee(fixedBasedPartTime);
                }
                else if(empType == "Commission Based")
                {
                    CommisionBasedPartTime commisionBasedPartTime = new CommisionBasedPartTime(Integer.parseInt(empid),empname,Integer.parseInt(empAge),empType,Float.parseFloat(emprate),Integer.parseInt(empHours),Integer.parseInt(empCommissionBased));
                    Singleton.getInstance().addEmployee(commisionBasedPartTime);
                }
                else if(empType == "Intern")
                {
                    Intern intern = new Intern(Integer.parseInt(empid),empname,Integer.parseInt(empAge),empType,empschool);
                    Singleton.getInstance().addEmployee(intern);
                }
                else if(empType == "Full Time"){
                    FullTime fullTime = new FullTime(Integer.parseInt(empid),empname,Integer.parseInt(empAge),empType,Integer.parseInt(empsalary),Integer.parseInt(empbonus));
                    Singleton.getInstance().addEmployee(fullTime);
                }
            }
        });





        return view;
    }
}
