package me.app.chamada;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarbas on 17/07/17.
 */

public class TurmasAdapter extends RecyclerView.Adapter<TurmasAdapter.LineHolder> {

    public interface OnClickItem {
        void onClickItem(int position);
    }

    private ArrayList<Turma> turmas;
    private OnClickItem callback;

    public TurmasAdapter(ArrayList<Turma> turmas, OnClickItem c) {

        this.turmas = turmas;
        this.callback = c;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chamada, parent, false), callback);
    }

    public static class LineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView turma;
        public TextView numero_alunos;
        public OnClickItem callback;

        public LineHolder(View itemView, OnClickItem c) {
            super(itemView);

            callback = c;
            turma = (TextView) itemView.findViewById(R.id.nome_turma);
            numero_alunos = (TextView) itemView.findViewById(R.id.numero_alunos);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            callback.onClickItem(getAdapterPosition());
        }
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position) {

        holder.turma.setText(turmas.get(position).getNome());
        holder.numero_alunos.setText(String.valueOf(turmas.get(position).getNumero_alunos()));
    }

    @Override
    public int getItemCount() {
        return turmas != null ? turmas.size() : 0;
    }
}