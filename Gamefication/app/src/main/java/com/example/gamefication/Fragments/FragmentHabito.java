package com.example.gamefication.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamefication.Activities.adicionarHabitos;
import com.example.gamefication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class FragmentHabito extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton add;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // TODO: Rename and change types and number of parameters
    public static FragmentHabito newInstance(String param1, String param2) {
        FragmentHabito fragment = new FragmentHabito();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentHabito() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_habito, container, false);
       recyclerView = view.findViewById(R.id.recyclerViewHabito);
        add = view.findViewById(R.id.floatingActionButtonAddHabito);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity fragmentActivity = getActivity();
                if(fragmentActivity != null){
                    startActivity(new Intent(fragmentActivity, adicionarHabitos.class));
                }
            }
        });

        return view;
    }
}