package com.example.antoniopedro.medicomais.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.data.Data;
import com.example.antoniopedro.medicomais.models.Consulta;

import java.util.ArrayList;


/**
 * Created by Antonio Pedro on 14/03/2018.
 */

public class ListMinhasConsultasAdapter extends RecyclerView.Adapter<ListMinhasConsultasAdapter.MyViewHolder> {

    private ArrayList<Consulta> mList;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ListMinhasConsultasAdapter(Context context, ArrayList<Consulta> mList, Activity activity) {

        this.activity = activity;
        this.mList = mList;
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_minhas_consultas_card, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtSintomasConsulta.setText(mList.get(position).getSintomas());
        holder.txtDataConsulta.setText(mList.get(position).getDataConsulta());
        holder.txtNomeMedico.setText(mList.get(position).getNomeMedico());
        holder.txtTipoConsulta.setText(mList.get(position).getTipoConsulta());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public TextView txtNomeMedico;
        public TextView txtTipoConsulta;
        public TextView txtDataConsulta;
        public TextView txtSintomasConsulta;




        public MyViewHolder(View itemView) {
            super(itemView);

            txtNomeMedico = (TextView) itemView.findViewById(R.id.txtNomeMedico);
            txtTipoConsulta = (TextView) itemView.findViewById(R.id.txtTipoConsulta);
            txtDataConsulta = (TextView) itemView.findViewById(R.id.txtDataConsulta);
            txtSintomasConsulta = (TextView) itemView.findViewById(R.id.txtSintomasConsulta);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }

}

