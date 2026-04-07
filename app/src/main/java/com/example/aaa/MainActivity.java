package com.example.aaa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- THE MAGIC SPELL CODE GOES HERE ---

        // 1. Find the Bottom Navigation Bar
        com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 2. Find the empty Fragment Container (the blank board holding your screens)
        androidx.navigation.fragment.NavHostFragment navHostFragment = (androidx.navigation.fragment.NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        // 3. Get the "GPS Controller" from that container
        androidx.navigation.NavController navController = navHostFragment.getNavController();

        // 4. Wire the Bottom Navigation Bar and the GPS Controller together!
        androidx.navigation.ui.NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}