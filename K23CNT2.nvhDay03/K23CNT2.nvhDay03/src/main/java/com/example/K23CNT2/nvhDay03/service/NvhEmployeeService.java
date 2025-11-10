package com.example.K23CNT2.nvhDay03.service;

import com.example.K23CNT2.nvhDay03.entity.NvhEmployee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NvhEmployeeService {
    private List<NvhEmployee> employees = new ArrayList<>();

    public NvhEmployeeService() {
        employees.addAll(Arrays.asList(
                new NvhEmployee(1L, "Nguyen Van A", "Nam", 30, 1500.0),
                new NvhEmployee(2L, "Tran Thi B", "Nu", 28, 1200.0),
                new NvhEmployee(3L, "Le Van C", "Nam", 35, 2000.0),
                new NvhEmployee(4L, "Pham Thi D", "Nu", 25, 1000.0),
                new NvhEmployee(5L, "Do Van E", "Nam", 40, 2500.0)
        ));
    }

    public List<NvhEmployee> getAll() { return employees; }

    public NvhEmployee getById(Long id) {
        return employees.stream().filter(e -> e.getNvhId().equals(id)).findFirst().orElse(null);
    }

    public NvhEmployee add(NvhEmployee e) {
        employees.add(e);
        return e;
    }

    public NvhEmployee update(Long id, NvhEmployee e) {
        NvhEmployee existing = getById(id);
        if (existing != null) {
            existing.setNvhFullName(e.getNvhFullName());
            existing.setNvhGender(e.getNvhGender());
            existing.setNvhAge(e.getNvhAge());
            existing.setNvhSalary(e.getNvhSalary());
        }
        return existing;
    }

    public boolean delete(Long id) {
        NvhEmployee existing = getById(id);
        return existing != null && employees.remove(existing);
    }
}
