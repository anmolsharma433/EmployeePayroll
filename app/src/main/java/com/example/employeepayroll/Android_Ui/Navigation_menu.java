package com.example.employeepayroll.Android_Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.employeepayroll.Android_Ui.Fragments.AddEmployeeFragment;
import com.example.employeepayroll.Android_Ui.Fragments.HomeFragment;
import com.example.employeepayroll.Android_Ui.Fragments.ViewEmployeeListFragment;
import com.example.employeepayroll.R;
import com.google.android.material.navigation.NavigationView;

public class Navigation_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        NavigationView navigationView =findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.navHome);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navHome:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
                break;

            case  R.id.navAddEmployee:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new AddEmployeeFragment()).commit();
                break;
            case R.id.navViewEmployee:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new ViewEmployeeListFragment()).commit();
                break;
            case R.id.navHelp:
                //dialog box yet to be added
                Toast.makeText(this,"We are happy to help You.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.navLogout:
                Intent intent = new Intent(Navigation_menu.this,LogIn.class);
                startActivity(intent);
                Toast.makeText(this,"you are successfully logged out",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
