package com.projectbp3.appcookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detail_resep extends AppCompatActivity {

    ImageView imageView;
    TextView title, premis, timer, bahan, langkah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_resep);

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            finish();
        });

        // Inisialisasi view
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.title);
        timer = findViewById(R.id.timer);
        bahan = findViewById(R.id.bahan);
        langkah = findViewById(R.id.langkah);

        // Ambil data dari Intent
        int image = getIntent().getIntExtra("image2", 0);
        String titleText = getIntent().getStringExtra("title");
        String timerText = getIntent().getStringExtra("timer");
        String bahanText = getIntent().getStringExtra("bahan");
        String langkahText = getIntent().getStringExtra("langkah");

        // Set data ke view
        imageView.setImageResource(image);
        title.setText(titleText);
        timer.setText(timerText);
        bahan.setText(bahanText);
        langkah.setText(langkahText);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}