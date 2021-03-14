package com.example.project1lyn;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_comon";
    private static final String tb_comon = "tb_comon";

    private static final String tb_comon_nama_toko = "nama_toko";
    private static final String tb_comon_tgl_pembelian = "tgl_pembelian";
    private static final String tb_comon_nama_produk = "nama_produk";
    private static final String tb_comon_harga_produk = "harga_produk";
    private static final String tb_comon_satuan = "satuan";

    private static final String CREATE_TABLE_COMON = "CREATE TABLE "+ tb_comon +"("
            + tb_comon_nama_toko +"TEXT ,"
            + tb_comon_tgl_pembelian +"TEXT ,"
            + tb_comon_nama_produk +"TEXT ,"
            + tb_comon_harga_produk +"TEXT ,"
            + tb_comon_satuan +"TEXT "+")";


    public DatabaseHandler (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE_COMON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateComon (Comon cNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_comon_nama_toko, cNotif.getNama_toko());
        values.put(tb_comon_tgl_pembelian, cNotif.getTgl_pembelian());
        values.put(tb_comon_nama_produk, cNotif.getNama_produk());
        values.put(tb_comon_harga_produk, cNotif.getHarga_produk());
        values.put(tb_comon_satuan, cNotif.getSatuan());
        db.insert(tb_comon, null, values);
        db.close();
    }
}
