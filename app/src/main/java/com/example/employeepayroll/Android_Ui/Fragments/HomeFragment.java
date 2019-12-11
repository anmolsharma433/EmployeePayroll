package com.example.employeepayroll.Android_Ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.employeepayroll.Android_Ui.Singleton;
import com.example.employeepayroll.Employee_Classes.Employee;
import com.example.employeepayroll.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment {
    TextView empCount,dateAndTime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        Singleton singleton = Singleton.getInstance();
        empCount = view.findViewById(R.id.empCount);
        dateAndTime = view.findViewById(R.id.textdateandtime);
        empCount.setText(String.valueOf(singleton.returnCount()));

        Calendar c = Calendar.getInstance();
        //System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MMMM-dd \n hh:mm:ss aa");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
        // Now we display formattedDate value in TextView
        dateAndTime.setText(formattedDate);
        return view;
    }
}
