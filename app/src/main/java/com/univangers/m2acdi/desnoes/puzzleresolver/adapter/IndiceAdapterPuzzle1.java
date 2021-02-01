package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import java.util.ArrayList;

public class IndiceAdapterPuzzle1 extends RecyclerView.Adapter<IndiceAdapterPuzzle1.ViewHolder> {

    Context context;
    private ArrayList<Indice> listeIndice;

    public IndiceAdapterPuzzle1(Context context) {
        this.context = context;
        this.listeIndice = new ArrayList<Indice>();
    }

    @NonNull
    @Override
    public IndiceAdapterPuzzle1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.ligne_indice, parent, false);
        return new IndiceAdapterPuzzle1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndiceAdapterPuzzle1.ViewHolder holder, int position) {
        Indice indice = this.listeIndice.get(position);

        holder.tv_textIndice.setText(indice.getText());
        holder.tv_textIndice.setTextColor(Color.DKGRAY);

        if(indice.isUsed()) {
            holder.tv_textIndice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            holder.tv_textIndice.setTextColor(Color.GREEN);
        } else {
            holder.tv_textIndice.setPaintFlags(0);
            holder.tv_textIndice.setTextColor(Color.DKGRAY);
        }

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return this.listeIndice.size();
    }


    public void ajoute(String indice, boolean isUsed) {
        this.listeIndice.add(new Indice(indice, isUsed));

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