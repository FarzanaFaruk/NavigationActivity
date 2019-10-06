package com.example.mynavactivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mynavactivity.ui.Accelerometer;
import com.example.mynavactivity.ui.Gyroscope;
import com.example.mynavactivity.ui.Gyroscope_Data;
import com.example.mynavactivity.ui.Map;
import com.example.mynavactivity.ui.Proximity;
import com.example.mynavactivity.ui.Shake;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_Accelerometer, R.id.nav_gyroscope, R.id.nav_proximity,
                R.id.nav_shake, R.id.nav_map, R.id.nav_data)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent;

        if (id == R.id.nav_Accelerometer) {
            intent = new Intent(this, Accelerometer.class);
            startActivity(intent);
        } else if (id == R.id.nav_gyroscope) {
            intent = new Intent(this, Gyroscope.class);
            startActivity(intent);
        } else if (id == R.id.nav_proximity) {
            intent = new Intent(this, Proximity.class);
            startActivity(intent);
        } else if (id == R.id.nav_shake) {
            intent = new Intent(this, Shake.class);
            startActivity(intent);
        } else if (id == R.id.nav_map) {
            intent = new Intent(this, Map.class);
            startActivity(intent);
        } else if (id == R.id.nav_data) {
            intent = new Intent(this, Gyroscope_Data.class);
            startActivity(intent);
        }

        return true;
    }
}
