package com.example.dharmani.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Colors implements Parcelable {
    String colors;
   int index;

    public Colors(String colors, int index) {
        this.colors = colors;
        this.index = index;
    }

    public Colors() {
    }

    protected Colors(Parcel in) {
        colors = in.readString();
    }

    public static final Creator<Colors> CREATOR = new Creator<Colors>() {
        @Override
        public Colors createFromParcel(Parcel in) {
            return new Colors(in);
        }

        @Override
        public Colors[] newArray(int size) {
            return new Colors[size];
        }
    };

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(colors);
    }
}
