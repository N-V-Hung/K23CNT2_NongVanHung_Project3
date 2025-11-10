package com.example.K23CNT2.nvhDay03.controller;

import com.example.K23CNT2.nvhDay03.entity.NvhEmployee;
import com.example.K23CNT2.nvhDay03.service.NvhEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class NvhEmployeeController {

    @Autowired
    private NvhEmployeeService employeeService;

    @GetMapping("/list")
    public List<NvhEmployee> getAll() { return employeeService.getAll(); }

    @GetMapping("/{id}")
    public NvhEmployee getById(@PathVariable Long id) { return employeeService.getById(id); }

    @PostMapping("/add")
    public NvhEmployee add(@RequestBody NvhEmployee e) { return employeeService.add(e); }

    @PutMapping("/{id}")
    public NvhEmployee update(@PathVariable Long id, @RequestBody NvhEmployee e) {
        return employeeService.update(id, e);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return employeeService.delete(id); }
}
