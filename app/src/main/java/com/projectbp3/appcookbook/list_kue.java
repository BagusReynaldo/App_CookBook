package com.projectbp3.appcookbook;

import android.content.Context;
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

public class list_kue extends AppCompatActivity {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_kue);

        recyclerView = findViewById(R.id.recyclerView_kue);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        recyclerview_list2 = new ArrayList<>();
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.kastangel,
                getString(R.string.premis_kastangel),
                "Kastangel tepung komachi",
                "50 Menit",
                R.drawable.kastangel2,
                getString(R.string.bahan_kastangel),
                getString(R.string.langkah_kastangel)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.putri_salju,
                getString(R.string.premis_purtisalju),
                "Putri Salju NCC",
                "50 Menit",
                R.drawable.putri_salju2,
                getString(R.string.bahan_purtisalju),
                getString(R.string.langkah_putrisalju)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.oat_cookies,
                getString(R.string.premis_oatCookies),
                "Oat Cookies",
                "60 Menit",
                R.drawable.oat_cookies2,
                getString(R.string.bahan_oat),
                getString(R.string.langkah_oat)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.meg_cheese,
                getString(R.string.premis_meg),
                "Meg Cheese ShortBread",
                "60 Menit",
                R.drawable.meg_cheese2,
                getString(R.string.bahan_meg_cheddar),
                getString(R.string.langkah_meg)
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