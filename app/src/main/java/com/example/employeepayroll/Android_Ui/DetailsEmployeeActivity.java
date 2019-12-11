package com.example.employeepayroll.Android_Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.CommisionBasedPartTime;
import com.example.employeepayroll.Employee_Classes.EmployeeType_partTime.FixedBasedPartTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.FullTime;
import com.example.employeepayroll.Employee_Classes.Employee_PartTime.Intern;
import com.example.employeepayroll.R;
import com.example.employeepayroll.VehicleRVAdapter;
import com.example.employeepayroll.Vehicle_Classes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DetailsEmployeeActivity extends AppCompatActivity {
    TextView empid, empname, empage, emptype, detailtext;
    LinearLayout intern,fulltime,parttime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_employee);

        empid = findViewById(R.id.textEmpID);
        empname = findViewById(R.id.textEmpName);
        empage = findViewById(R.id.textEmpAge);
        emptype = findViewById(R.id.textEmptype);
        intern = findViewById(R.id.layoutintern);
        fulltime = findViewById(R.id.layoutfulltime);
        parttime = findViewById(R.id.layoutparttime);
        detailtext = findViewById(R.id.detailtext1);

        Employee myemp = getIntent().getParcelableExtra("empobject");
        empid.setText(String.valueOf(myemp.getEmployeeId()));
        empname.setText(myemp.getName());
        empage.setText(myemp.getAge() + "Years");
        emptype.setText(myemp.getType());


        if(myemp.getType().equalsIgnoreCase("intern"))
        {

            intern.setVisibility(View.VISIBLE);
            TextView school = findViewById(R.id.textEmpschool);
            Intern myintern = new Intern();
            school.setText(myintern.getSchoolName());

        }

        else if(myemp.getType().equalsIgnoreCase("fulltime"))
        {

            fulltime.setVisibility(View.VISIBLE);
            FullTime myfultime = new FullTime();
            TextView salary = findViewById(R.id.textEmpsalaryfulltime);
            TextView totalsalary = findViewById(R.id.textEmptotalsalaryftime);
            salary.setText(myfultime.getSalary() + " $ + " + myfultime.getBonus() + " $ (C)" );
            String totalftimesalary = (myfultime.getSalary() + myfultime.getBonus()) + " $";
            totalsalary.setText(totalftimesalary);

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Fixed Amount"))
        {
            FixedBasedPartTime myFixedbase = new FixedBasedPartTime();


            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commision = findViewById(R.id.textEmpcommisionptime);
            float salary = myFixedbase.getHoursWorked() * myFixedbase.getRate();
            salaryptime.setText(String.valueOf(salary));
            String totalptimesalary = String.valueOf(salary + myFixedbase.getFixedAmount());
            commision.setText(myFixedbase.getFixedAmount() + " $");
            totalsalaryptime.setText(totalptimesalary + " $");

        }
        else if(myemp.getType().equalsIgnoreCase("PartTime / Commissioned"))
        {

            CommisionBasedPartTime mycommisionBasedPartTime = new CommisionBasedPartTime();
            parttime.setVisibility(View.VISIBLE);
            TextView salaryptime = findViewById(R.id.textEmpsalaryparttime);
            TextView totalsalaryptime = findViewById(R.id.textEmptotalsalaryptime);
            TextView commisionpercent = findViewById(R.id.textEmpcommisionptime);
            Float salary = mycommisionBasedPartTime.getHoursWorked() * mycommisionBasedPartTime.getRate();
            salaryptime.setText(salary + " $)" );
            Float commision = salary * mycommisionBasedPartTime.getCommisionPercentage()/100;
            String totalpctimesalary = String.valueOf(salary + commision);
            commisionpercent.setText(mycommisionBasedPartTime.getCommisionPercentage() + " %");
            totalsalaryptime.setText(totalpctimesalary + " $");

        }




        Employee empnewdata = getIntent().getParcelableExtra("empobject");
        String detail = empnewdata.getName() + "\n" + empnewdata.getType() + "\n";

        List<Vehicle> myvehicles = empnewdata.getVehicle();

        for (int i = 0; i <= myvehicles.size()-1; i++) {

            Vehicle myvehicle = myvehicles.get(i);
//            detail = detail + myvehicle.getMake() + "   " + myvehicle.getModel();

            if (myvehicle ==  null)
            {
                detailtext.setText("No vehicles Registered");
                //List<Vehicle> mybills = new ArrayList<Vehicle>();

                Toast.makeText(this,"No vehicle", Toast.LENGTH_SHORT).show();

            }
            else {

                List<Vehicle> mv = myemp.getVehicle();


                RecyclerView recyclerView1 = findViewById(R.id.recycler_vehicle);
                final VehicleRVAdapter vehicleDataAdapter = new VehicleRVAdapter(this);
                vehicleDataAdapter.setMyaaraylist(mv);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView1.setLayoutManager(layoutManager);
                recyclerView1.setAdapter(vehicleDataAdapter);




                final Singleton singleton = Singleton.getInstance();




            }

        }
//        empdetail.setText(detail);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_vehicle,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //add intent for add vehicle
        //Intent intent = new Intent(DetailsEmployeeActivity.this,AddVehicleActivity.class);
       // startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
