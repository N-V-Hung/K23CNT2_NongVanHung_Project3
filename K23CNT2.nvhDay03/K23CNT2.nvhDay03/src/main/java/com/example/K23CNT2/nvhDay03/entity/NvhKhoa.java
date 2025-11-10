package com.example.K23CNT2.nvhDay03.entity;

public class NvhKhoa {


    private String nvhMaKhoa;
    private String nvhTenKhoa;

    public NvhKhoa() {
    }

    public NvhKhoa(String nvhMaKhoa, String nvhTenKhoa) {
        this.nvhMaKhoa = nvhMaKhoa;
        this.nvhTenKhoa = nvhTenKhoa;
    }

    public String getNvhMaKhoa() {
        return nvhMaKhoa;
    }

    public void setNvhMaKhoa(String nvhMaKhoa) {
        this.nvhMaKhoa = nvhMaKhoa;
    }

    public String getNvhTenKhoa() {
        return nvhTenKhoa;
    }

    public void setNvhTenKhoa(String nvhTenKhoa) {
        this.nvhTenKhoa = nvhTenKhoa;
    }
}
