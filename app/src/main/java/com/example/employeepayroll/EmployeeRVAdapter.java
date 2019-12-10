package com.example.employeepayroll;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeepayroll.Employee_Classes.Employee;

import java.util.List;

public class EmployeeRVAdapter extends RecyclerView.Adapter<EmployeeRVAdapter.ViewHolder> {

    private Context context;
    private List<Employee> myaaraylist;


    public EmployeeRVAdapter(Context context) {
        this.context = context;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Employee> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Employee> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_employee_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Employee mydata = myaaraylist.get(position);


        holder.name.setText("Employee Name: " + mydata.getName());
        holder.id.setText("Employee ID: " + String.valueOf(mydata.getEmployeeId()));


    }


    @Override
    public int getItemCount() {
        return myaaraylist.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, id;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            id = itemView.findViewById(R.id.empid);
            name = itemView.findViewById(R.id.empname);


        }
    }
}