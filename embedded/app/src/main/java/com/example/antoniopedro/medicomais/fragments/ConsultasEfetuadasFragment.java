package com.example.antoniopedro.medicomais.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.adapter.ListMedicosAdapter;
import com.example.antoniopedro.medicomais.adapter.ListMinhasConsultasAdapter;
import com.example.antoniopedro.medicomais.data.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultasEfetuadasFragment extends android.app.Fragment {

    RecyclerView recyclerView;

    public ConsultasEfetuadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_consultas_efetuadas, container, false);



        this.recyclerView = rootView.findViewById(R.id.rvListMinhasConsultas);

        recyclerView.setAdapter( new ListMinhasConsultasAdapter(getActivity().getApplicationContext(), Data.minhasConsultas, getActivity()));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layout);



        // Inflate the layout for this fragment
        return rootView;
    }

}
