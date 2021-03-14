package com.example.project1lyn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class TransaksiActivity extends AppCompatActivity {
    private TextView tvDate;
    private EditText etDate;
    private DatePickerDialog.OnDateSetListener setListener;

    private DatabaseHandler db;
    private EditText edToko, edProduk, edHarga, edSatuan;
    private String sToko, sDate, sProduk, sHarga, sSatuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        db = new DatabaseHandler(this);

        edToko = findViewById(R.id.edtToko);
        edProduk = findViewById(R.id.edtProduk);
        edHarga = findViewById(R.id.edtHarga);
        edSatuan = findViewById(R.id.edtSatuan);

        tvDate = findViewById(R.id.tv_date);
        etDate = findViewById(R.id.ed_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONDAY);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        TransaksiActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);
            }
        };
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        TransaksiActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        Button btnSimpan = (Button)findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sToko = String.valueOf(edToko.getText());
                sDate = String.valueOf(etDate.getText());
                sProduk = String.valueOf(edProduk.getText());
                sHarga = String.valueOf(edHarga.getText());
                sSatuan = String.valueOf(edSatuan.getText());

                if (sToko.equals("")) {
                    edToko.requestFocus();
                    Toast.makeText(TransaksiActivity.this, "Masukkan Nama Toko", Toast.LENGTH_SHORT).show();
                } else if (sProduk.equals("")) {
                    Toast.makeText(TransaksiActivity.this, "Masukkan Nama Produk", Toast.LENGTH_SHORT).show();
                }else if (sDate.equals("")) {
                    Toast.makeText(TransaksiActivity.this, "Masukkan Tanggal Pembelian", Toast.LENGTH_SHORT).show();
                }
                else if (sHarga.equals("")) {
                    Toast.makeText(TransaksiActivity.this, "Masukkan Harga Produk", Toast.LENGTH_SHORT).show();
                } else if (sSatuan.equals("")) {
                    Toast.makeText(TransaksiActivity.this, "Masukkan Satuan", Toast.LENGTH_SHORT).show();
                } else {
                    edToko.setText("");
                    edProduk.setText("");
                    edHarga.setText("");
                    edSatuan.setText("");
                    Toast.makeText(TransaksiActivity.this, "Data Telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateComon(new Comon(sToko, sDate, sProduk, sHarga, sSatuan));
                }
            }
        });

    }
}