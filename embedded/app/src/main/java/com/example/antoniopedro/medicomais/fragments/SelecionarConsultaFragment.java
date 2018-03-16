package com.example.antoniopedro.medicomais.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.antoniopedro.medicomais.MainActivity;
import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.adapter.ListEspecialidadesAdapter;
import com.example.antoniopedro.medicomais.data.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelecionarConsultaFragment extends android.app.Fragment {


    RecyclerView recyclerView;

    public SelecionarConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_selecionar_consulta, container, false);

        this.recyclerView = rootView.findViewById(R.id.rvListEspecialides);

        recyclerView.setAdapter( new ListEspecialidadesAdapter(getActivity().getApplicationContext(), Data.nomeConsulta, getActivity()));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layout);
        return rootView;
    }

}
