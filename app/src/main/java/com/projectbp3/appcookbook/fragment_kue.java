package com.projectbp3.appcookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_kue#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_kue extends Fragment {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_kue() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_kue.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_kue newInstance(String param1, String param2) {
        fragment_kue fragment = new fragment_kue();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kue, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_kue);
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

        recyclerview_adapter2 adapter = new recyclerview_adapter2(recyclerview_list2, getContext());
        recyclerView.setAdapter(adapter);

        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}