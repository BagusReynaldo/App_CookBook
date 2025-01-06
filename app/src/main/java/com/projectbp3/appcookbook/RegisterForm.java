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

public class RegisterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_form);

        Button register = findViewById(R.id.btn_register);
        register.setOnClickListener(v -> {

            // Ambil input dari form
            EditText passInput = findViewById(R.id.txt_password);
            EditText passInputAgain = findViewById(R.id.txt_passwordAgain);
            EditText emailInput = findViewById(R.id.txt_email);

            String email = emailInput.getText().toString().trim();
            String password = passInput.getText().toString().trim();
            String passwordAgain = passInputAgain.getText().toString().trim();

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

            // Validasi ulang password kosong
            if (passwordAgain.isEmpty()) {
                passInputAgain.setError("Ulangi password tidak boleh kosong!");
                passInputAgain.requestFocus();
                return;
            }

            // Validasi password dan konfirmasi password
            if (!password.equals(passwordAgain)) {
                passInputAgain.setError("Password tidak cocok!");
                passInputAgain.requestFocus();
                return;
            }

            // Simpan email dan password ke SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email); // Simpan email
            editor.putString("password", password); // Simpan password
            editor.apply(); // Terapkan perubahan

            // Beralih ke LoginForm
            Intent intent = new Intent(RegisterForm.this, LoginForm.class);
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