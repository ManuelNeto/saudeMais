package com.example.antoniopedro.medicomais.fragments;


import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.adapter.ListEspecialidadesAdapter;
import com.example.antoniopedro.medicomais.adapter.ListMedicosAdapter;
import com.example.antoniopedro.medicomais.data.Data;


import android.app.DatePickerDialog;
import android.widget.Toast;

/**
 *
 *
 * A simple {@link Fragment} subclass.
 */
public class EscolhaMedicoFragment extends android.app.Fragment {

    ImageButton imageButton;
    TextView nomeDaConsulta;
    RecyclerView recyclerView;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    public EscolhaMedicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_escolha_medico, container, false);

        this.nomeDaConsulta = (TextView) rootView.findViewById(R.id.txtNomeDaConsulta);

        this.nomeDaConsulta.setText(Data.nomeDaConsulta);

        this.recyclerView = rootView.findViewById(R.id.rvListMedicos);

        String[] nomeMedicos = {""};

        switch (Data.nomeDaConsulta){
            case "Odontologico":
                nomeMedicos = Data.medicosOdontologicos;
                break;
            case "Cardiologista":
                nomeMedicos = Data.medicosCardiologista;
                break;
            case "Oftamologista":
                nomeMedicos = Data.medicosOftamologista;
                break;
            case "Clinico geral":
                nomeMedicos = Data.medicosClinicoGeral;
                break;
            default:
        }

        recyclerView.setAdapter( new ListMedicosAdapter(getActivity().getApplicationContext(), nomeMedicos, getActivity()));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layout);

        this.imageButton = rootView.findViewById(R.id.btnDataConsulta);

        this.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int ano = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        onDateSetListener,
                        ano, mes, dia);

                datePickerDialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {

                Data.dataConsulta = dia+"/"+(mes+1)+"/"+ano;

                Log.i("data", Data.dataConsulta);
                Log.i("nomeMedico", Data.nomeMedico);
                Log.i("nomeConsulta", Data.nomeDaConsulta);
                Log.i("sintomas", Data.sintomas);

                if(Data.nomeMedico.equals("")){
                    Toast.makeText(getActivity().getApplicationContext(), "Selecione um medico", Toast.LENGTH_LONG).show();
                }else{
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.content_frame, new SintomasFragment()).commit();
                }


            }
        };

        // Inflate the layout for this fragment
        return rootView;
    }

}
