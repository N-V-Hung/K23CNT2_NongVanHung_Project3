package com.example.K23CNT2.nvhDay03.entity;

public class NvhMonHoc {
    private String nvhMaMH;
    private String nvhTenMH;
    private int nvhSoTiet;

    public NvhMonHoc() {}

    public NvhMonHoc(String nvhMaMH, String nvhTenMH, int nvhSoTiet) {
        this.nvhMaMH = nvhMaMH;
        this.nvhTenMH = nvhTenMH;
        this.nvhSoTiet = nvhSoTiet;
    }

    public String getNvhMaMH() {
        return nvhMaMH;
    }

    public void setNvhMaMH(String nvhMaMH) {
        this.nvhMaMH = nvhMaMH;
    }

    public String getNvhTenMH() {
        return nvhTenMH;
    }

    public void setNvhTenMH(String nvhTenMH) {
        this.nvhTenMH = nvhTenMH;
    }

    public int getNvhSoTiet() {
        return nvhSoTiet;
    }

    public void setNvhSoTiet(int nvhSoTiet) {
        this.nvhSoTiet = nvhSoTiet;
    }
}
