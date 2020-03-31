package com.example.daumobile.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Program extends RealmObject {
    @PrimaryKey
    int id_program;
    String ten_chuong_trinh_dao_tao;
    String ma_hoc_phan;
    String ten_hoc_phan;
    boolean loai_hoc_phan;
    int so_tin_chi;
    int hoc_ky;

    public Program(int id_program, String ten_chuong_trinh_dao_tao, String ma_hoc_phan, String ten_hoc_phan, boolean loai_hoc_phan, int so_tin_chi,int hoc_ky) {
        this.id_program = id_program;
        this.ten_chuong_trinh_dao_tao = ten_chuong_trinh_dao_tao;
        this.ma_hoc_phan = ma_hoc_phan;
        this.ten_hoc_phan = ten_hoc_phan;
        this.loai_hoc_phan = loai_hoc_phan;
        this.so_tin_chi = so_tin_chi;
        this.hoc_ky = hoc_ky;
    }

    public Program() {
    }

    public int getId_program() {
        return id_program;
    }

    public void setId_program(int id_program) {
        this.id_program = id_program;
    }

    public String getTen_chuong_trinh_dao_tao() {
        return ten_chuong_trinh_dao_tao;
    }

    public void setTen_chuong_trinh_dao_tao(String ten_chuong_trinh_dao_tao) {
        this.ten_chuong_trinh_dao_tao = ten_chuong_trinh_dao_tao;
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

    public int getHoc_ky() {
        return hoc_ky;
    }

    public void setHoc_ky(int hoc_ky) {
        this.hoc_ky = hoc_ky;
    }
}
