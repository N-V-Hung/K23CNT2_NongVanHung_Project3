package com.example.K23CNT2.nvhDay03.entity;

public class NvhStudent {
    private Long NvhId;
    private String NvhName;
    private int NvhAge;
    private String NvhGender;
    private String NvhAddress;
    private String NvhPhone;
    private String NvhEmail;

    public NvhStudent() {
    }

    public NvhStudent(Long nvhId, String nvhName, int nvhAge, String nvhGender, String nvhAddress, String nvhPhone, String nvhEmail) {
        NvhId = nvhId;
        NvhName = nvhName;
        NvhAge = nvhAge;
        NvhGender = nvhGender;
        NvhAddress = nvhAddress;
        NvhPhone = nvhPhone;
        NvhEmail = nvhEmail;
    }

    public Long getNvhId() {
        return NvhId;
    }

    public void setNvhId(Long nvhId) {
        NvhId = nvhId;
    }

    public String getNvhEmail() {
        return NvhEmail;
    }

    public void setNvhEmail(String nvhEmail) {
        NvhEmail = nvhEmail;
    }

    public String getNvhPhone() {
        return NvhPhone;
    }

    public void setNvhPhone(String nvhPhone) {
        NvhPhone = nvhPhone;
    }

    public String getNvhAddress() {
        return NvhAddress;
    }

    public void setNvhAddress(String nvhAddress) {
        NvhAddress = nvhAddress;
    }

    public String getNvhGender() {
        return NvhGender;
    }

    public void setNvhGender(String nvhGender) {
        NvhGender = nvhGender;
    }

    public int getNvhAge() {
        return NvhAge;
    }

    public void setNvhAge(int nvhAge) {
        NvhAge = nvhAge;
    }

    public String getNvhName() {
        return NvhName;
    }

    public void setNvhName(String nvhName) {
        NvhName = nvhName;
    }
}
