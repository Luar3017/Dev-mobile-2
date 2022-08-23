package com.example.gamefication.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamefication.R;

import java.util.List;

public class HabitoAdapter extends RecyclerView.Adapter<HabitoViewHolder>{
    List<String> listaHabitos;

    public HabitoAdapter(List<String> listaHabitos) {
        this.listaHabitos = listaHabitos;
    }

    @NonNull
    @Override
    public HabitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new HabitoViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitoViewHolder holder, int position) {
        holder.titulo.setText(listaHabitos.get(position));
        holder.descricao.setText(listaHabitos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaHabitos.size();
    }
}

class HabitoViewHolder extends RecyclerView.ViewHolder{
    TextView titulo, descricao;
    HabitoAdapter adapter;

    public HabitoViewHolder(@NonNull View itemView) {
        super(itemView);

        titulo = itemView.findViewById(R.id.textViewCardTitulo);
        descricao = itemView.findViewById(R.id.textViewDesc);
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
