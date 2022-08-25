package com.example.gamefication.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamefication.Objetos.Habito;
import com.example.gamefication.R;

import java.util.ArrayList;
import java.util.List;

public class HabitoAdapter extends RecyclerView.Adapter<HabitoViewHolder>{
    Context context;
    List<Habito> listaHabitos;

    public HabitoAdapter(Context context, List<Habito> listaHabitos) {
        this.listaHabitos = listaHabitos;
        this.context = context;
    }

    @NonNull
    @Override
    public HabitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new HabitoViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitoViewHolder holder, int position) {
        Habito habitos = listaHabitos.get(position);
        holder.CardTitulo.setText(habitos.getTituloH());
        holder.CardDesc.setText(habitos.getObservacaoH());
    }

    @Override
    public int getItemCount() {
        return listaHabitos.size();
    }
}

class HabitoViewHolder extends RecyclerView.ViewHolder{
    TextView CardTitulo, CardDesc;
    HabitoAdapter adapter;

    public HabitoViewHolder(@NonNull View itemView) {
        super(itemView);

        CardTitulo = itemView.findViewById(R.id.CardTitulo);
        CardDesc = itemView.findViewById(R.id.CardDesc);
        itemView.findViewById(R.id.imageButtonFazer).setOnClickListener(view -> {
            // Implementar
        });
        itemView.findViewById(R.id.imageButtonRemover).setOnClickListener(view -> {
            adapter.listaHabitos.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });
    }

    public HabitoViewHolder linkAdapter(HabitoAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
