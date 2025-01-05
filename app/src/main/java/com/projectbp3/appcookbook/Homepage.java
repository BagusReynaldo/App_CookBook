package com.projectbp3.appcookbook;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    ArrayList<recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerview_list = new ArrayList<>();
        recyclerview_list.add(new recyclerview_list("Kue Kering", R.drawable.kue_kering, new fragment_kue()));
        //recyclerview_list.add(new recyclerview_list("Masakan Indonesia", R.drawable.masakan_indo, list_masakan_indo.class));
        //recyclerview_list.add(new recyclerview_list("Pastry", R.drawable.pastry, list_pastry.class));
        //recyclerview_list.add(new recyclerview_list("Bolu", R.drawable.bolu, list_bolu.class));
        //recyclerview_list.add(new recyclerview_list("Es Krim", R.drawable.eskrim , list_eskrim.class));
        //recyclerview_list.add(new recyclerview_list("Masakan Kuah", R.drawable.masakan_kuah, list_masakan_kuah.class));


        recyclerview_adapter adapter = new recyclerview_adapter(recyclerview_list, this);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}