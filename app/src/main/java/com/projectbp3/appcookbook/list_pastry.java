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

public class list_pastry extends AppCompatActivity {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_pastry);

        recyclerView = findViewById(R.id.recyclerView_pastry);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        recyclerview_list2 = new ArrayList<>();
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.cromboloni,
                getString(R.string.premis_cromboloni),
                "Cromboloni",
                "90 Menit",
                R.drawable.cromboloni2,
                getString(R.string.bahan_cromboloni),
                getString(R.string.langkah_cromboloni)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.puff,
                getString(R.string.premis_puff),
                "Puff Pastry Selai Nanas",
                "60 Menit",
                R.drawable.puff2,
                getString(R.string.bahan_puff),
                getString(R.string.langkah_puff)
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