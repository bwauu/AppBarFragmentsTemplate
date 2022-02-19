package com.example.savedatabetweenfragmentswitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    /* 1. Declarations */
    // Declare same amount of fragments as menu items
    private Fragment aFragment, bFragment;
    // Declare BottomNavigationView
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 2. Initializations of reference variables */
        // Initialize all fragments

        // Fragment A & B Initialization
        aFragment = new AFragment();
        bFragment = new BFragment();

        // BottomNavigationView Initialization
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_component);
        // 3. Finally set listener to BottomNavigationView items with setOnItemSelectedListener() method.
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // 3.1 Create a switch case that checks parameter item's id through getItemId() method.
                // 3.2 Case all the items and replace view through transaction with getSupportFragmentManger
                // 3.3 Commit
                switch (item.getItemId()) {
                    case R.id.home_icon:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameObjectSwitcher,aFragment).commit();
                        return true;
                    case R.id.favorite_icon:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameObjectSwitcher,bFragment).commit();
                        return true;
                }
                return false;
            }
        });

        // If you want to start the application with a specific Fragment uncomment this code below
        // getSupportFragmentManager().beginTransaction().replace(R.id.FrameObjectSwitcher,aFragment).commit();
    }
}