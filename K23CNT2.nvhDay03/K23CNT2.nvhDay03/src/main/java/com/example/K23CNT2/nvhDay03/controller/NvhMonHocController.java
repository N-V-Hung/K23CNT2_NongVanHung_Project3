package com.example.K23CNT2.nvhDay03.controller;

import com.example.K23CNT2.nvhDay03.entity.NvhMonHoc;
import com.example.K23CNT2.nvhDay03.service.NvhMonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monhoc")
public class NvhMonHocController {

    @Autowired
    private NvhMonHocService monHocService;

    @GetMapping("/list")
    public List<NvhMonHoc> getAll() { return monHocService.getAll(); }

    @GetMapping("/{maMH}")
    public NvhMonHoc getById(@PathVariable String nvhMaMH) { return monHocService.getById(nvhMaMH); }

    @PostMapping("/add")
    public NvhMonHoc add(@RequestBody NvhMonHoc mh) { return monHocService.add(mh); }

    @PutMapping("/{maMH}")
    public NvhMonHoc update(@PathVariable String nvhMaMH, @RequestBody NvhMonHoc mh) {
        return monHocService.update(nvhMaMH, mh);
    }

    @DeleteMapping("/{maMH}")
    public boolean delete(@PathVariable String nvhMaMH) { return monHocService.delete(nvhMaMH); }
}
