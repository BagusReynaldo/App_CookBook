package com.projectbp3.appcookbook;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list_masakan_kuah extends AppCompatActivity {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_masakan_kuah);

        recyclerView = findViewById(R.id.recyclerView_kuah);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        recyclerview_list2 = new ArrayList<>();
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.wonton,
                getString(R.string.premis_wonton),
                "Sup Wonton Daging Ayam",
                "60 Menit",
                R.drawable.wonton2,
                getString(R.string.bahan_wonton),
                getString(R.string.langkah_wonton)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.kol,
                getString(R.string.premis_kol),
                "Kembang Kol Kuah fiber Cream",
                "50 Menit",
                R.drawable.kol2,
                getString(R.string.bahan_kol),
                getString(R.string.langkah_kol)
        ));


        recyclerview_adapter2 adapter = new recyclerview_adapter2(recyclerview_list2, this, false);
        recyclerView.setAdapter(adapter);

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