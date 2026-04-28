package com.example.aaa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class noteAdapter extends RecyclerView.Adapter<noteAdapter.noteHolder> {
   List<note> notes;
    public noteAdapter(List<note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public noteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        return new noteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noteHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.noteHead.setText(notes.get(position).getNoteHead());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class noteHolder extends RecyclerView.ViewHolder{
        TextView noteHead;

        public noteHolder(@NonNull View itemView) {
            super(itemView);
            noteHead = itemView.findViewById(R.id.noteHead);
        }
    }
}
