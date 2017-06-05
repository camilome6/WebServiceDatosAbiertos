package com.example.sistemas.webservicedatosabiertos.models;


import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sistemas.webservicedatosabiertos.R;

import java.util.ArrayList;

/**
 * Created by sistemas on 5/06/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Acueducto> dataset;

    private Context context;

    public Adapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acueducto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Acueducto a = dataset.get(position);
        holder.barrio.setText(a.getBarrio());
        holder.armaEmpleada.setText(a.getArmaEmpleada().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaAuto(ArrayList<Acueducto> listaAcueducto) {
        dataset.addAll(listaAcueducto);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView barrio;
        private TextView armaEmpleada;

        public ViewHolder(View itemView) {
            super(itemView);


            barrio= (TextView) itemView.findViewById(R.id.barrio);
            armaEmpleada= (TextView) itemView.findViewById(R.id.armaEmpleada);

        }
    }
}

