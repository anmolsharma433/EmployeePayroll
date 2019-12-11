package com.example.employeepayroll.Android_Ui.Fragments;

import android.content.Intent;
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

import com.example.employeepayroll.Android_Ui.DetailsEmployeeActivity;
import com.example.employeepayroll.Android_Ui.Singleton;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.CommisionBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.FixedBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.PartTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.FullTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.Intern;
import com.example.employeepayroll.R;

public class AddEmployeeFragment extends Fragment implements View.OnClickListener {
    EditText id, name, email, Age, commissionBased, fixedBased, hoursworked, rate, ratemcommissionPer, school, salary, bonus;
    RadioGroup employeeType, partTimeType;
    CheckBox vehicle, commOrFixed;
    RadioButton comBased, fixBased, fullTime, partTime, intern;
    ImageView vehicleImg;
    Button savePayroll;
    LinearLayout ly_partTime, ly_intern, ly_fulltime;
    String empType, empname, emprate, empschool, empFixedBased, empsalary, empbonus, empHours, empCommissionBased;
    int empid = 0;
    int empAge = 0;
    Singleton addemployeobj = Singleton.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_employee, container, false);
        id = view.findViewById(R.id.edtId);
        name = view.findViewById(R.id.edtName);
        email = view.findViewById(R.id.etEmail);
        Age = view.findViewById(R.id.edtDob);
        hoursworked = view.findViewById(R.id.edtHours);
        rate = view.findViewById(R.id.edtRate);
        school = view.findViewById(R.id.edtSchoolName);
        salary = view.findViewById(R.id.edtSalary);
        bonus = view.findViewById(R.id.edtBonus);
        employeeType = view.findViewById(R.id.rgbEmployeeType);
        fullTime = view.findViewById(R.id.rbFulltime);

        intern = view.findViewById(R.id.rbIntern);
        partTimeType = view.findViewById(R.id.part_Time_check);
        comBased = view.findViewById(R.id.rbcommission_Based);
        fixBased = view.findViewById(R.id.rbfixed_Based);
        savePayroll = view.findViewById(R.id.btnSavePayroll);
        ly_partTime = view.findViewById(R.id.linear_Part_Time);
        ly_intern = view.findViewById(R.id.linearIntern);
        ly_fulltime = view.findViewById(R.id.linearFulltime);
        //partTime editText
        commissionBased = view.findViewById(R.id.commission_Based);
        fixedBased = view.findViewById(R.id.fixed_Based);

        //hiding the Fields on startup
        ly_partTime.setVisibility(View.GONE);
        ly_fulltime.setVisibility(View.GONE);
        ly_intern.setVisibility(View.GONE);
        commissionBased.setVisibility(View.GONE);
        fixedBased.setVisibility(View.GONE);


        //RadioButton group Employee Type
        employeeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i) {
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
        savePayroll.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View view) {

        //getting the value from fields
        empid = Integer.parseInt(id.getText().toString());
        empname = name.getText().toString();
//        String empEmail = String.valueOf(email.getText());
        empAge = Integer.parseInt(Age.getText().toString());
        emprate = String.valueOf(rate.getText());
        empFixedBased = String.valueOf(fixedBased.getText());
        empHours = String.valueOf(hoursworked.getText());
        empCommissionBased = commissionBased.getText().toString();

        empschool = school.getText().toString();
        empsalary = String.valueOf(salary.getText());
        empbonus = String.valueOf(bonus.getText());


        if (empType == "Fixed Based") {

            FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime(empid, empname, empAge, empType, Float.parseFloat(emprate), Integer.parseInt(empHours), Integer.parseInt(empFixedBased));
            addemployeobj.addEmployee(fixedBasedPartTime);
        } else if (empType == "Commission Based") {

            CommisionBasedPartTime commisionBasedPartTime = new CommisionBasedPartTime(empid, empname, empAge, empType, Float.parseFloat(emprate), Integer.parseInt(empHours), Integer.parseInt(empCommissionBased));
            addemployeobj.addEmployee(commisionBasedPartTime);
        } else if (empType == "Intern") {
            Intern intern = new Intern(empid, empname, empAge, empType, empschool);
            addemployeobj.addEmployee(intern);
            intern.setSchoolName(empschool);

            System.out.println("Emp intern" + empid + empschool);
        } else if (empType == "Full Time") {
            FullTime fullTime = new FullTime(empid ,empname, empAge, empType, Integer.parseInt(empsalary), Integer.parseInt(empbonus));
            addemployeobj.addEmployee(fullTime);
            System.out.println("fixed base" + empType);
                getActivity().onBackPressed();

        }

    }
}














