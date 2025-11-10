package com.example.K23CNT2.nvhDay03.controller;


import com.example.K23CNT2.nvhDay03.entity.NvhStudent;
import com.example.K23CNT2.nvhDay03.service.NvhStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class NvhStudentController {

    @Autowired
    private NvhStudentService nvhStudentService;

    @GetMapping("/list")
    public List<NvhStudent> getAll() {
        return nvhStudentService.getAllNvhStudent();
    }

    @PostMapping("/add")
    public NvhStudent add(@RequestBody NvhStudent nvhStudent){
        return  nvhStudentService.addNvhStudent(nvhStudent);
    }

    @PutMapping("/{NvhId}")
    public  boolean update(@PathVariable long nvhId){
        return nvhStudentService.deleteNvhStudent(nvhId);
    }
}
