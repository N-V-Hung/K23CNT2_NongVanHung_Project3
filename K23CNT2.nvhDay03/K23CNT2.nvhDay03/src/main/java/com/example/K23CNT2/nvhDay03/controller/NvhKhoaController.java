package com.example.K23CNT2.nvhDay03.controller;

import com.example.K23CNT2.nvhDay03.entity.NvhKhoa;
import com.example.K23CNT2.nvhDay03.service.NvhKhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khoa")
public class NvhKhoaController {

    @Autowired
    private NvhKhoaService khoaService;

    @GetMapping("/list")
    public List<NvhKhoa> getAll() {
        return khoaService.getAll();
    }

    @GetMapping("/{maKhoa}")
    public NvhKhoa getById(@PathVariable String nvhMaKhoa) {
        return khoaService.getById(nvhMaKhoa);
    }

    @PostMapping("/add")
    public NvhKhoa add(@RequestBody NvhKhoa khoa) {
        return khoaService.add(khoa);
    }

    @PutMapping("/{maKhoa}")
    public NvhKhoa update(@PathVariable String nvhMaKhoa, @RequestBody NvhKhoa khoa) {
        return khoaService.update(nvhMaKhoa, khoa);
    }

    @DeleteMapping("/{maKhoa}")
    public boolean delete(@PathVariable String nvhMaKhoa) {
        return khoaService.delete(nvhMaKhoa);
    }
}
