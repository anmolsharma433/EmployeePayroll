package com.example.employeepayroll;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeepayroll.Android_Ui.DetailsEmployeeActivity;
import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

import java.util.List;

public class VehicleRVAdapter extends RecyclerView.Adapter<VehicleRVAdapter.ViewHolder> {

    private Context context;
    private List<Vehicle> vehicleList;


    public VehicleRVAdapter(Context context) {
        this.context = context;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Vehicle> getMyaaraylist() {
        return vehicleList;
    }

    public void setMyaaraylist(List<Vehicle> vehiclelist) { this.vehicleList = vehiclelist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_vehicle_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Vehicle vdata = vehicleList.get(position);


        holder.make.setText("Model: " + vdata.getModel());
        holder.model.setText("Make: " + vdata.getMake());
        holder.plate.setText("Plate: " + vdata.getPlate());
        holder.type.setText("Vehicle type: " + vdata.getType());
        if (vdata.isInsurance() == true)
        {
            holder.insurance.setText(R.string.have_insurance);

        }
        else
        {
            holder.insurance.setText(R.string.no_insurance);

        }
        holder.insurance.setText("Make: " + vdata.isInsurance());
        holder.mylAYOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(context, DetailsEmployeeActivity.class);
                myintent.putExtra("vehicleObj", vdata);
                context.startActivity(myintent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return vehicleList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView make, model;
        TextView plate, insurance;
        TextView type;
        LinearLayout mylAYOUT;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mylAYOUT = itemView.findViewById(R.id.vehicle_layout);

            model = itemView.findViewById(R.id.vmodel);
            make = itemView.findViewById(R.id.vmake);
            plate = itemView.findViewById(R.id.vplae);
            type = itemView.findViewById(R.id.vtype);
            insurance = itemView.findViewById(R.id.vInsurance);



        }
    }
}