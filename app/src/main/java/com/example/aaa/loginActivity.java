package com.example.aaa;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //not auto gen3
        // 1. Find the button
        android.widget.Button loginBtn = findViewById(R.id.loginbtn); // Change R.id.button if your ID is different!

// 2. Make it click
        loginBtn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                // 3. Create the Intent to switch to MainActivity
                android.content.Intent intent = new android.content.Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);

                // 4. Destroy the login screen so they can't hit the "Back" arrow to return here!
                finish();
            }
        });
    }
}