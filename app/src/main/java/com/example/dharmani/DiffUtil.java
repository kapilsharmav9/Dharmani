package com.example.dharmani;

import com.example.dharmani.Model.Colors;

import java.util.ArrayList;

public class DiffUtil extends androidx.recyclerview.widget.DiffUtil.Callback {
    ArrayList<Colors>oldList;
    ArrayList<Colors> newList;

    public DiffUtil(ArrayList<Colors> oldList, ArrayList<Colors> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition==newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition)==newList.get(newItemPosition);
    }
}
