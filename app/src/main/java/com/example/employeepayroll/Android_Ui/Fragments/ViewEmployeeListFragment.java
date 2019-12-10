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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeepayroll.Android_Ui.Singleton;
import com.example.employeepayroll.EmployeeRVAdapter;
import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.JasonParsing;
import com.example.employeepayroll.R;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployeeListFragment extends Fragment {
    String json,temps;
    ArrayList<Employee> empdatalist;
    Singleton myobj = Singleton.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_employee, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JasonParsing jasonParsing = new JasonParsing();
        json = jasonParsing.loadJSONFromAsset(getContext());

        Gson gson = new Gson();

        try {
            JSONArray jsonarray = new JSONArray(json);

            for(int i =0 ; i<=jsonarray.length();i++)
            {

                temps = jsonarray.get(i).toString();
                Employee employee = gson.fromJson(temps,Employee.class);
                myobj.addEmployee(employee);

//                List<Vehicle> myvehicles = employee.getVehicle();
//                for
//
//                Vehicle vehicleData = gson.fromJson(temps,Vehicle.class);
//                myobj.addVehicle(vehicleData);



            }
        }catch (JSONException e) {

            initRecycleView();
        }


    }

    private  void initRecycleView()
    {


        RecyclerView recyclerView = getView().findViewById(R.id.employee_rv);
        ArrayList<Employee> mylist = myobj.getEmployees();
        EmployeeRVAdapter employeeRVAdapter = new EmployeeRVAdapter(getActivity());
        employeeRVAdapter.setMyaaraylist(mylist);
        recyclerView.setAdapter(employeeRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));




    }
    }





