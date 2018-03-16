package com.example.antoniopedro.medicomais.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.antoniopedro.medicomais.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarcarConsultaFragment extends android.app.Fragment {

    Button btnMarcarConsulta;

    
    public MarcarConsultaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_marcar_consulta, container, false);

        this.btnMarcarConsulta = (Button) rootView.findViewById(R.id.btnMarcarConsulta);

        btnMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().beginTransaction().replace(R.id.content_frame, new SelecionarConsultaFragment()).commit();
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
