package com.projectbp3.appcookbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_form);

        Button register = findViewById(R.id.btn_register);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginForm.this, RegisterForm.class);
            startActivity(intent);
        });

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(v -> {
            Intent intent = new Intent(LoginForm.this, Homepage.class);
            startActivity(intent);
        });

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}