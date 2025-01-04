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

public class list_bolu extends AppCompatActivity {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_bolu);

        recyclerView = findViewById(R.id.recyclerView_bolu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        recyclerview_list2 = new ArrayList<>();
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.bolu_pisang,
                getString(R.string.premis_pisang),
                "Bolu Pisang Panggang",
                "90 Menit",
                R.drawable.bolu_pisang2,
                getString(R.string.bahan_pisang),
                getString(R.string.langkah_pisang)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.bolu_pepaya,
                getString(R.string.premis_pepaya),
                "Bolu Pepaya",
                "120 Menit",
                R.drawable.bolu_pepaya2,
                getString(R.string.bahan_pepaya),
                getString(R.string.langkah_pepaya)
        ));


        recyclerview_adapter2 adapter = new recyclerview_adapter2(recyclerview_list2, this);
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