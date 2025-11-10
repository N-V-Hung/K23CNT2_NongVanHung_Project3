package com.example.K23CNT2.nvhDay03.service;

import com.example.K23CNT2.nvhDay03.entity.NvhKhoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NvhKhoaService {
    private List<NvhKhoa> khoas = new ArrayList<>();

    public NvhKhoaService() {
        khoas.addAll(Arrays.asList(
                new NvhKhoa("CNTT", "Công nghệ thông tin"),
                new NvhKhoa("KT", "Kế toán"),
                new NvhKhoa("QTKD", "Quản trị kinh doanh"),
                new NvhKhoa("NN", "Ngoại ngữ"),
                new NvhKhoa("DL", "Du lịch")
        ));
    }

    public List<NvhKhoa> getAll() {
        return khoas;
    }

    public NvhKhoa getById(String nvhMaKhoa) {
        return khoas.stream()
                .filter(k -> k.getNvhMaKhoa().equalsIgnoreCase(nvhMaKhoa))
                .findFirst().orElse(null);
    }

    public NvhKhoa add(NvhKhoa khoa) {
        khoas.add(khoa);
        return khoa;
    }

    public NvhKhoa update(String nvhMaKhoa, NvhKhoa khoa) {
        NvhKhoa existing = getById(nvhMaKhoa);
        if (existing != null) {
            existing.setNvhTenKhoa(khoa.getNvhTenKhoa());
        }
        return existing;
    }

    public boolean delete(String nvhMaKhoa) {
        NvhKhoa existing = getById(nvhMaKhoa);
        return existing != null && khoas.remove(existing);
    }
}
