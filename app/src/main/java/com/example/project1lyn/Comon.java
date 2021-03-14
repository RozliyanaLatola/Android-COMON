package com.example.project1lyn;

public class Comon {
    private String nama_toko, tgl_pembelian, nama_produk, harga_produk, satuan;

    public Comon(String nama_toko1, String tgl_pembelian1, String nama_produk1, String harga_produk1, String satuan1){
        this.nama_toko = nama_toko1;
        this.tgl_pembelian = tgl_pembelian1;
        this.nama_produk = nama_produk1;
        this.harga_produk = harga_produk1;
        this.satuan = satuan1;
    }

    public String getNama_toko() {
        return nama_toko;
    }

    public void setNama_toko(String nama_toko) {
        this.nama_toko = nama_toko;
    }

    public String getTgl_pembelian() {
        return tgl_pembelian;
    }

    public void setTgl_pembelian(String tgl_pembelian) {
        this.tgl_pembelian = tgl_pembelian;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
