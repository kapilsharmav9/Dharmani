package com.example.dharmani.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dharmani.Activity2;
import com.example.dharmani.Model.Colors;
import com.example.dharmani.R;

import java.util.ArrayList;

public class RecycleAdapterTop extends RecyclerView.Adapter<RecycleAdapterTop.holder> {
    Context context;
    ArrayList<Colors> colorsList;

    public RecycleAdapterTop(Context context, ArrayList<Colors> colorsList) {
        this.context = context;
        this.colorsList = colorsList;
    }

    @NonNull
    @Override
    public RecycleAdapterTop.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_design2, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterTop.holder holder, int position) {
        Colors colors = colorsList.get(position);
        holder.txt_color.setText(colors.getColors());

    }

    @Override
    public int getItemCount() {
        if (colorsList.isEmpty()) {
            return 0;
        } else {
            return colorsList.size();
        }
    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button button;
        TextView txt_color;

        public holder(@NonNull View itemView) {
            super(itemView);
            txt_color=itemView.findViewById(R.id.color_textTT);
            button = itemView.findViewById(R.id.btn_next);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            Intent intent=new Intent(context, Activity2.class);
            intent.putExtra("name",colorsList.get(position).getColors());
            intent.putExtra("colors", colorsList);
            intent.putExtra("postion", position);
            context.startActivity(intent);
        }
    }
}
