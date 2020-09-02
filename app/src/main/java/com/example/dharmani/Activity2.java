package com.example.dharmani;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dharmani.Model.Colors;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    TextView txt_color;
    Button btn_delete;
    ArrayList<Colors> colorsArrayList;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txt_color = findViewById(R.id.text_color);
        btn_delete = findViewById(R.id.btn_delete);
        Intent i = getIntent();
        final String colorname = i.getStringExtra("name");
        index = i.getIntExtra("position",0);
        colorsArrayList = i.getParcelableArrayListExtra("colors");
        txt_color.setText(colorname);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               colorsArrayList.remove(index);
               startActivity(new Intent(Activity2.this,MainActivity.class));
               finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            colorsArrayList.remove(index);
        } else {

        }
    }
}