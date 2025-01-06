package com.projectbp3.appcookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_eskrim#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_eskrim extends Fragment {

    AutoCompleteTextView ac;
    public String[] dataList = {"Kue Kering", "Masakan Indonesia", "Pastry", "Bolu", "Es Krim", "Masakan Kuah"};

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_eskrim() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_eskrim.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_eskrim newInstance(String param1, String param2) {
        fragment_eskrim fragment = new fragment_eskrim();
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
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_eskrim, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_eskrim);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        // Inisialisasi AutoCompleteTextView
        ac = (AutoCompleteTextView) view.findViewById(R.id.txt_search);
        ac.setAdapter(new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, dataList));

        // Tambahkan listener untuk item yang dipilih
        ac.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedItem = parent.getItemAtPosition(position).toString();

            if (selectedItem.equals("Kue Kering")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_kue())
                        .addToBackStack(null)
                        .commit();
            } else if (selectedItem.equals("Masakan Indonesia")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_indo())
                        .addToBackStack(null)
                        .commit();
            } else if (selectedItem.equals("Pastry")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_pastry())
                        .addToBackStack(null)
                        .commit();
            } else if (selectedItem.equals("Bolu")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_bolu())
                        .addToBackStack(null)
                        .commit();
            } else if (selectedItem.equals("Es Krim")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_eskrim())
                        .addToBackStack(null)
                        .commit();
            } else if (selectedItem.equals("Masakan Kuah")) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new fragment_kuah())
                        .addToBackStack(null)
                        .commit();
            }

        });

        recyclerview_list2 = new ArrayList<>();
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