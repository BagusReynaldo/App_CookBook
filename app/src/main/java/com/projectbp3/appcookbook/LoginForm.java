package com.projectbp3.appcookbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(v -> {
            // Ambil input email dan password dari form
            EditText passInput = findViewById(R.id.txt_password);
            EditText emailInput = findViewById(R.id.txt_email);
            String email = emailInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();

            // Validasi email kosong
            if (email.isEmpty()) {
                emailInput.setError("Email tidak boleh kosong!");
                emailInput.requestFocus();
                return;
            }

            // Validasi password kosong
            if (password.isEmpty()) {
                passInput.setError("Password tidak boleh kosong!");
                passInput.requestFocus();
                return;
            }

            // Ambil data dari SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            String registeredEmail = sharedPreferences.getString("email", ""); // Ambil email tersimpan
            String registeredPassword = sharedPreferences.getString("password", ""); // Ambil password tersimpan

            // Validasi apakah email dan password sesuai dengan yang terdaftar
            if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
                // Jika sesuai, lanjut ke Homepage1
                Intent intent = new Intent(LoginForm.this, Homepage1.class);
                startActivity(intent);
            } else {
                // Jika tidak sesuai, tampilkan pesan error
                emailInput.setError("Email atau password salah!");
                emailInput.requestFocus();
            }
        });



        Button register = findViewById(R.id.btn_register);
        register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginForm.this, RegisterForm.class);
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