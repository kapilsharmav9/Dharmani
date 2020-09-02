package com.example.dharmani.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dharmani.Activity2;
import com.example.dharmani.DiffUtil;
import com.example.dharmani.MainActivity;
import com.example.dharmani.Model.Colors;
import com.example.dharmani.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.holder> {
    Context context;
    ArrayList<Colors> colorsList;


    public RecycleAdapter(Context context, ArrayList<Colors> colorsList) {
        this.context = context;
        this.colorsList = colorsList;

    }

    private void updateData(ArrayList<Colors> updateList) {

        DiffUtil diffUtil = new DiffUtil(colorsList, updateList);
        androidx.recyclerview.widget.DiffUtil.DiffResult result = androidx.recyclerview.widget.DiffUtil.calculateDiff(diffUtil);
        colorsList.clear();
        colorsList.addAll(updateList);
        result.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public RecycleAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecycleAdapter.holder holder, int position) {
        Colors colors = colorsList.get(position);
        holder.color_txt.setText(colors.getColors());

    }

    @Override
    public int getItemCount() {
        if (colorsList.isEmpty()) {
            return 0;
        } else {
            return colorsList.size();
        }
    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView color_txt;

        public holder(@NonNull View itemView) {
            super(itemView);
            color_txt = itemView.findViewById(R.id.color_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context,MainActivity.class);
            intent.putExtra("name", colorsList.get(position).getColors());
            intent.putExtra("position", position);
            intent.putExtra("colors", colorsList);
            context.startActivity(intent);

        }


    }


}
