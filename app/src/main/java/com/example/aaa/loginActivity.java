package com.example.aaa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        EditText email = findViewById(R.id.emailTV);
        EditText password = findViewById(R.id.passTV);
        Button loginBtn = findViewById(R.id.loginbtn);

        loginBtn.setOnClickListener(v ->{
            String defMail = "a@gmail.com";
            String defPass = "123456";
            if(email.getText().toString().equals(defMail) && password.getText().toString().equals(defPass)){
                android.content.Intent intent = new android.content.Intent(loginActivity.this, MainActivity.class);
               intent.putExtra("email", email.getText().toString());
                startActivity(intent);

            }
            else{
                Toast.makeText(loginActivity.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
            });
        }
    }