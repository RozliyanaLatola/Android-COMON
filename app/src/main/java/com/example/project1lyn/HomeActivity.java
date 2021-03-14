package com.example.project1lyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnTrans;
    private Button btnLap;
    private Button btnTtg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnTrans = findViewById(R.id.btnTrans);
        btnLap = findViewById(R.id.btnLap);
        btnTtg = findViewById(R.id.btnTtg);

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(HomeActivity.this,TransaksiActivity.class);
                startActivity(int1);
            }
        });

        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(HomeActivity.this,LaporanActivity.class);
                startActivity(int2);
            }
        });

        btnTtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(HomeActivity.this,TentangActivity.class);
                startActivity(int3);
            }
        });
    }
}