package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import java.util.ArrayList;

public class IndiceAdapter extends RecyclerView.Adapter<IndiceAdapter.ViewHolder> {

    Context context;
    private ArrayList<String> listeIndice;

    public IndiceAdapter(Context context) {
        this.context = context;
        this.listeIndice = new ArrayList<String>();
    }

    @NonNull
    @Override
    public IndiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.ligne_indice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndiceAdapter.ViewHolder holder, int position) {
        String indice = this.listeIndice.get(position);

        holder.tv_textIndice.setText(indice);

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.listeIndice.size();
    }


    public void ajoute(String indice) {
        this.listeIndice.add(indice);

        this.notifyItemInserted(this.listeIndice.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_textIndice;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_textIndice = (TextView)itemView.findViewById(R.id.tv_textIndice);
        }
    }
}
