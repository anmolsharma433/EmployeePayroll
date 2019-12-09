package com.example.employeepayroll.Android_Ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.employeepayroll.R;

import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {


    TextView banner;
    EditText email;
    EditText password;
    Button login;
    TextView dm;
    Switch sw;
    //Id for layout
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        banner = findViewById(R.id.txtBanner);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        cl = findViewById(R.id.clLayout);

        //setting the values at startUp
        email.setText("user@employee.com");
        password.setText("s3cr3t");

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().length() != 0) {
                    if(isValidEmailId(email.getText().toString().trim())){
                        if (email.getText().toString().equals("user@employee.com") && password.getText().toString().equals("s3cr3t")) {
                            Toast.makeText(LogIn.this, "You are loggedin.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LogIn.this,Navigation_menu.class);
                            startActivity(intent);
                        }
                    }else {
                        Toast.makeText(LogIn.this, "Your email id or password is incorrect.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    alertDialog();
                }
            }
        });

    }


    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Login Error");
        dialog.setMessage("Please Enter the required Fields");
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}


