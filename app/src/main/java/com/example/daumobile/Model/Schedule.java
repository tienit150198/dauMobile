package com.example.daumobile.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Schedule extends RealmObject {
    @PrimaryKey
    int id_schedule;
    String ma_lop_hp;
    String ten_hoc_phan;
    boolean loai_hoc_phan;
    int so_tin_chi;
    String _class;
    int so_tiet;
    String giang_vien;
    String ngay_hoc;
    String buoi;
    String tiet;
    String phong;
    String thoi_gian;
    int tuan;

    public Schedule() {
    }

    public Schedule(int id_schedule, String ma_lop_hp, String ten_hoc_phan, boolean loai_hoc_phan, int so_tin_chi, String _class, int so_tiet, String giang_vien, String ngay_hoc, String buoi, String tiet, String phong, String thoi_gian, int tuan) {
        this.id_schedule = id_schedule;
        this.ma_lop_hp = ma_lop_hp;
        this.ten_hoc_phan = ten_hoc_phan;
        this.loai_hoc_phan = loai_hoc_phan;
        this.so_tin_chi = so_tin_chi;
        this._class = _class;
        this.so_tiet = so_tiet;
        this.giang_vien = giang_vien;
        this.ngay_hoc = ngay_hoc;
        this.buoi = buoi;
        this.tiet = tiet;
        this.phong = phong;
        this.thoi_gian = thoi_gian;
        this.tuan = tuan;
    }

    public String getMa_lop_hp() {
        return ma_lop_hp;
    }

    public void setMa_lop_hp(String ma_lop_hp) {
        this.ma_lop_hp = ma_lop_hp;
    }

    public String getTen_hoc_phan() {
        return ten_hoc_phan;
    }

    public void setTen_hoc_phan(String ten_hoc_phan) {
        this.ten_hoc_phan = ten_hoc_phan;
    }

    public boolean isLoai_hoc_phan() {
        return loai_hoc_phan;
    }

    public void setLoai_hoc_phan(boolean loai_hoc_phan) {
        this.loai_hoc_phan = loai_hoc_phan;
    }

    public int getSo_tin_chi() {
        return so_tin_chi;
    }

    public void setSo_tin_chi(int so_tin_chi) {
        this.so_tin_chi = so_tin_chi;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public int getSo_tiet() {
        return so_tiet;
    }

    public void setSo_tiet(int so_tiet) {
        this.so_tiet = so_tiet;
    }

    public String getGiang_vien() {
        return giang_vien;
    }

    public void setGiang_vien(String giang_vien) {
        this.giang_vien = giang_vien;
    }

    public String getNgay_hoc() {
        return ngay_hoc;
    }

    public void setNgay_hoc(String ngay_hoc) {
        this.ngay_hoc = ngay_hoc;
    }

    public String getBuoi() {
        return buoi;
    }

    public void setBuoi(String buoi) {
        this.buoi = buoi;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getThoi_gian() {
        return thoi_gian;
    }

    public void setThoi_gian(String thoi_gian) {
        this.thoi_gian = thoi_gian;
    }

    public int getTuan() {
        return tuan;
    }

    public void setTuan(int tuan) {
        this.tuan = tuan;
    }
}
