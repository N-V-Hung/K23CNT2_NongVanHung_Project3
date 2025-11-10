package com.example.K23CNT2.nvhDay03.service;


import com.example.K23CNT2.nvhDay03.controller.NvhStudentController;
import com.example.K23CNT2.nvhDay03.entity.NvhStudent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NvhStudentService {
    private List<NvhStudent> nvhsts = new ArrayList<>();

    public NvhStudentService() {
        nvhsts.addAll(Arrays.asList(
                new NvhStudent(1L, "Nguyen Van A", 20, "Nam", "Ha Noi", "0901112233", "a@gmail.com"),
                new NvhStudent(2L, "Tran Thi B", 22, "Nu", "Da Nang", "0902223344", "b@gmail.com"),
                new NvhStudent(3L, "Le Van C", 21, "Nam", "Sai Gon", "0903334455", "c@gmail.com")
        ));
    }
    public List<NvhStudent> getAllNvhStudent(){
        return nvhsts;
    }

    public NvhStudent getNvhStudentById(long nvhId){
        return nvhsts.stream()
                .filter(s ->s.getNvhId().equals(nvhId))
                .findFirst()
                .orElse(null);

    }
     public NvhStudent addNvhStudent(NvhStudent nvhStudent){
        nvhsts.add(nvhStudent);
        return nvhStudent;
     }

     public NvhStudent updateNvhStudent(long nvhId, NvhStudent nvhStudent){
        NvhStudent existing = getNvhStudentById(nvhId);
        if (existing != null){
            existing.setNvhName(nvhStudent.getNvhName());
            existing.setNvhAddress((nvhStudent.getNvhAddress()));
            existing.setNvhGender(nvhStudent.getNvhGender());
            existing.setNvhAddress(nvhStudent.getNvhAddress());
            existing.setNvhPhone(nvhStudent.getNvhPhone());
            existing.setNvhEmail(nvhStudent.getNvhEmail());
        }
        return existing;
     }

     public boolean deleteNvhStudent(long nvhId){
        NvhStudent exising = getNvhStudentById(nvhId);
        return exising!= null && nvhsts.remove(exising);

     }

}
