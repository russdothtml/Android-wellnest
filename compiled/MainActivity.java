package com.example.wellnestlayoutjournal;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;


            int id = item.getItemId();
            if (id == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (id == R.id.nav_planner) {
                selectedFragment = new PlannerFragment();
            } else if (id == R.id.nav_journal) {
                selectedFragment = new JournalFragment();
            } else if (id == R.id.nav_exercises) {
                selectedFragment = new ExercisesFragment();
            } else if (id == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
            }


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }
}
