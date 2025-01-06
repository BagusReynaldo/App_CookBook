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
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.vanila,
                getString(R.string.premis_vanila),
                "Eskrim Vanilla Cookies",
                "60 Menit",
                R.drawable.vanila2,
                getString(R.string.bahan_vanila),
                getString(R.string.langkah_vanila)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.buah_naga,
                getString(R.string.premis_buahnaga),
                "Es Krim Buah Naga",
                "30 Menit",
                R.drawable.buah_naga2,
                getString(R.string.bahan_buahnaga),
                getString(R.string.langkah_buahnaga)
        ));
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
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.gado_gado,
                getString(R.string.premis_gado),
                "Bumbu Kacang (Gado-gado)",
                "30 Menit",
                R.drawable.gado_gado2,
                getString(R.string.bahan_gado),
                getString(R.string.langkah_gado)
        ));
        recyclerview_list2.add(new recyclerview_list2(
                R.drawable.semur_sapi,
                getString(R.string.premis_semursapi),
                "Semur Daging Sapi",
                "75 Menit",
                R.drawable.semur_sapi2,
                getString(R.string.bahan_semur),
                getString(R.string.langkah_semur)
        ));
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

        // Filter item yang di-bookmark
        ArrayList<recyclerview_list2> savedItems = new ArrayList<>();
        for (String bookmarkedId : recyclerview_adapter2.bookmarkedItems) {
            for (recyclerview_list2 item : recyclerview_list2) {
                if (item.getUniqueId().equals(bookmarkedId)) { // Bandingkan ID unik
                    savedItems.add(item);
                }
            }
        }


        recyclerview_adapter2 adapter = new recyclerview_adapter2(savedItems, getContext(), false);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
