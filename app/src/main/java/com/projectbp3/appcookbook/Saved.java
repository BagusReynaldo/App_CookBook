package com.projectbp3.appcookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Saved extends Fragment {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    public Saved() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView_saved);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        // Data untuk RecyclerView
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
                "Kembang Kol Kuah Fiber Cream",
                "50 Menit",
                R.drawable.kol2,
                getString(R.string.bahan_kol),
                getString(R.string.langkah_kol)
        ));
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

        // Set Adapter ke RecyclerView
        recyclerview_adapter2 adapter = new recyclerview_adapter2(recyclerview_list2, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
