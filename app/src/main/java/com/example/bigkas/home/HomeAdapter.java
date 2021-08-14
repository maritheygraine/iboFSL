package com.example.bigkas.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bigkas.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private static final List<Integer> ITEMS = new ArrayList<Integer>() {
        {
            add(R.string.step_1);
            add(R.string.step_2);
            add(R.string.step_3);
        }
    };

    private Context context;

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.bigkas_steps_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int position) {
        final Resources resources = context.getResources();
        holder.bind(resources.getString(ITEMS.get(position)));
    }

    @Override
    public int getItemCount() {
        return ITEMS.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder implements Binder {

        private final TextView description;
        private final TextView number;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            number = itemView.findViewById(R.id.number);
        }

        @Override
        public void bind(String description) {
            this.description.setText(description);
            this.number.setText(String.valueOf(getAdapterPosition()+1));
        }
    }

    interface Binder {
        void bind(String description);
    }
}
