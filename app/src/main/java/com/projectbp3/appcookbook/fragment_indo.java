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
 * Use the {@link fragment_indo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_indo extends Fragment {

    ArrayList<recyclerview_list2> recyclerview_list2;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_indo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_indo.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_indo newInstance(String param1, String param2) {
        fragment_indo fragment = new fragment_indo();
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

        View view = inflater.inflate(R.layout.fragment_indo, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_indo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        recyclerview_list2 = new ArrayList<>();
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

        recyclerview_adapter2 adapter = new recyclerview_adapter2(recyclerview_list2, getContext());
        recyclerView.setAdapter(adapter);

        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}