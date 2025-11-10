package com.example.K23CNT2.nvhDay03.entity;

public class NvhEmployee {
    private Long nvhId;
    private String nvhFullName;
    private String nvhGender;
    private int nvhAge;
    private double nvhSalary;

    public NvhEmployee() {}


    public NvhEmployee(Long nvhId, String nvhFullName, String nvhGender, int nvhAge, double nvhSalary) {
        this.nvhId = nvhId;
        this.nvhFullName = nvhFullName;
        this.nvhGender = nvhGender;
        this.nvhAge = nvhAge;
        this.nvhSalary = nvhSalary;
    }

    public Long getNvhId() {
        return nvhId;
    }

    public void setNvhId(Long nvhId) {
        this.nvhId = nvhId;
    }

    public String getNvhFullName() {
        return nvhFullName;
    }

    public void setNvhFullName(String nvhFullName) {
        this.nvhFullName = nvhFullName;
    }

    public String getNvhGender() {
        return nvhGender;
    }

    public void setNvhGender(String nvhGender) {
        this.nvhGender = nvhGender;
    }

    public int getNvhAge() {
        return nvhAge;
    }

    public void setNvhAge(int nvhAge) {
        this.nvhAge = nvhAge;
    }

    public double getNvhSalary() {
        return nvhSalary;
    }

    public void setNvhSalary(double nvhSalary) {
        this.nvhSalary = nvhSalary;
    }
}
