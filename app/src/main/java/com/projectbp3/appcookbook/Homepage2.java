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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homepage2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homepage2 extends Fragment {

    AutoCompleteTextView ac;
    public String[] dataList = {"Kue Kering", "Masakan Indonesia", "Pastry", "Bolu", "Es Krim", "Masakan Kuah"};

    ArrayList<recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Homepage2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homepage2.
     */
    // TODO: Rename and change types and number of parameters
    public static Homepage2 newInstance(String param1, String param2) {
        Homepage2 fragment = new Homepage2();
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
        View view = inflater.inflate(R.layout.fragment_homepage2, container, false);

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

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

        // Inisialisasi data RecyclerView
        recyclerview_list = new ArrayList<>();
        recyclerview_list.add(new recyclerview_list("Kue Kering", R.drawable.kue_kering, new fragment_kue()));
        recyclerview_list.add(new recyclerview_list("Masakan Indonesia", R.drawable.masakan_indo, new fragment_indo()));
        recyclerview_list.add(new recyclerview_list("Pastry", R.drawable.pastry, new fragment_pastry()));
        recyclerview_list.add(new recyclerview_list("Bolu", R.drawable.bolu, new fragment_bolu()));
        recyclerview_list.add(new recyclerview_list("Es Krim", R.drawable.eskrim, new fragment_eskrim()));
        recyclerview_list.add(new recyclerview_list("Masakan Kuah", R.drawable.masakan_kuah, new fragment_kuah()));

        // Atur adapter RecyclerView
        recyclerview_adapter adapter = new recyclerview_adapter(recyclerview_list, requireContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

}