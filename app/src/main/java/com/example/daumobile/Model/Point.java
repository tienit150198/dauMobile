package com.example.daumobile.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Point extends RealmObject {
    @PrimaryKey
    private int id_point;
    private String ma_hoc_phan;
    private String ten_hoc_phan;
    private int so_tin_chi;
    private boolean loai_mon_hoc;
    private int diem_lan_1;
    private String diem_chu_lan_1;
    private int diem_lan_2;
    private String diem_chu_lan_2;
    private int hoc_ky;
    public Point() {
    }

    public Point(int id_point, String ma_hoc_phan, String ten_hoc_phan, int so_tin_chi, boolean loai_mon_hoc, int diem_lan_1, String diem_chu_lan_1, int diem_lan_2, String diem_chu_lan_2, int hoc_ky) {
        this.id_point = id_point;
        this.ma_hoc_phan = ma_hoc_phan;
        this.ten_hoc_phan = ten_hoc_phan;
        this.so_tin_chi = so_tin_chi;
        this.loai_mon_hoc = loai_mon_hoc;
        this.diem_lan_1 = diem_lan_1;
        this.diem_chu_lan_1 = diem_chu_lan_1;
        this.diem_lan_2 = diem_lan_2;
        this.diem_chu_lan_2 = diem_chu_lan_2;
        this.hoc_ky = hoc_ky;
    }

    public int getId_point() {
        return id_point;
    }

    public void setId_point(int id_point) {
        this.id_point = id_point;
    }

    public String getMa_hoc_phan() {
        return ma_hoc_phan;
    }

    public void setMa_hoc_phan(String ma_hoc_phan) {
        this.ma_hoc_phan = ma_hoc_phan;
    }

    public String getTen_hoc_phan() {
        return ten_hoc_phan;
    }

    public void setTen_hoc_phan(String ten_hoc_phan) {
        this.ten_hoc_phan = ten_hoc_phan;
    }

    public int getSo_tin_chi() {
        return so_tin_chi;
    }

    public void setSo_tin_chi(int so_tin_chi) {
        this.so_tin_chi = so_tin_chi;
    }

    public boolean isLoai_mon_hoc() {
        return loai_mon_hoc;
    }

    public void setLoai_mon_hoc(boolean loai_mon_hoc) {
        this.loai_mon_hoc = loai_mon_hoc;
    }

    public int getDiem_lan_1() {
        return diem_lan_1;
    }

    public void setDiem_lan_1(int diem_lan_1) {
        this.diem_lan_1 = diem_lan_1;
    }

    public String getDiem_chu_lan_1() {
        return diem_chu_lan_1;
    }

    public void setDiem_chu_lan_1(String diem_chu_lan_1) {
        this.diem_chu_lan_1 = diem_chu_lan_1;
    }

    public int getDiem_lan_2() {
        return diem_lan_2;
    }

    public void setDiem_lan_2(int diem_lan_2) {
        this.diem_lan_2 = diem_lan_2;
    }

    public String getDiem_chu_lan_2() {
        return diem_chu_lan_2;
    }

    public void setDiem_chu_lan_2(String diem_chu_lan_2) {
        this.diem_chu_lan_2 = diem_chu_lan_2;
    }

    public int getHoc_ky() {
        return hoc_ky;
    }

    public void setHoc_ky(int hoc_ky) {
        this.hoc_ky = hoc_ky;
    }
}
