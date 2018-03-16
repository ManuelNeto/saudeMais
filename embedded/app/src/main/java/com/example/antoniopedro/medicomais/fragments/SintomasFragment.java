package com.example.antoniopedro.medicomais.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.data.Data;
import com.example.antoniopedro.medicomais.models.Consulta;

/**
 * A simple {@link Fragment} subclass.
 */
public class SintomasFragment extends android.app.Fragment {


    EditText edtSintoma;
    Button btnConfimar;

    public SintomasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_sintomas, container, false);

        this.edtSintoma = (EditText) rootview.findViewById(R.id.edtSintomas);
        this.btnConfimar = (Button) rootview.findViewById(R.id.btnConfirmar);

        this.btnConfimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Consulta consulta =  new Consulta(Data.nomeMedico, Data.nomeDaConsulta, Data.dataConsulta, edtSintoma.getText().toString());
                Data.minhasConsultas.add(consulta);

                Data.nomeMedico = "";
                Data.nomeDaConsulta = "";
                Data.dataConsulta = "";

                Toast.makeText(getActivity().getApplicationContext(), "Consulta Marcada com sucesso.", Toast.LENGTH_LONG).show();

                getActivity().getFragmentManager().beginTransaction().replace(R.id.content_frame, new MarcarConsultaFragment()).commit();


            }
        });

        // Inflate the layout for this fragment
        return rootview;
    }

}
