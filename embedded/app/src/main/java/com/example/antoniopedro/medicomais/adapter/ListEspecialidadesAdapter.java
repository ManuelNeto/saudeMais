package com.example.antoniopedro.medicomais.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antoniopedro.medicomais.R;
import com.example.antoniopedro.medicomais.data.Data;
import com.example.antoniopedro.medicomais.fragments.EscolhaMedicoFragment;
import com.example.antoniopedro.medicomais.fragments.SelecionarConsultaFragment;

import java.util.List;


/**
 * Created by Antonio Pedro on 14/03/2018.
 */

public class ListEspecialidadesAdapter extends RecyclerView.Adapter<ListEspecialidadesAdapter.MyViewHolder> {

    private String[] mList;
    private Context context;
    private LayoutInflater mLayoutInflater;
    private Activity activity;

    public ListEspecialidadesAdapter(Context context, String[] mList, Activity activity) {

        this.activity = activity;
        this.mList = mList;
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_especialidade_card, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.rvTxtNomeUser.setText(mList[position]);


        holder.rvTxtNomeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.nomeDaConsulta = mList[position];
                activity.getFragmentManager().beginTransaction().replace(R.id.content_frame, new EscolhaMedicoFragment()).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        public TextView rvTxtNomeUser;



        public MyViewHolder(View itemView) {
            super(itemView);

            rvTxtNomeUser = (TextView) itemView.findViewById(R.id.rvTxtNomeUser);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }

}

