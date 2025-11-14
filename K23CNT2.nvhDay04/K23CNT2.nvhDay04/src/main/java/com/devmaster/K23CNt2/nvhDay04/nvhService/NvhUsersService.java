package com.devmaster.K23CNt2.nvhDay04.nvhService;


import com.devmaster.K23CNt2.nvhDay04.nvhEntity.NvhUsers;
import com.devmaster.K23CNt2.nvhDay04.nvhDto.NvhUserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NvhUsersService {
    List<NvhUsers> nvhUsersList =new ArrayList<NvhUsers>();

    public NvhUsersService(){
        nvhUsersList.add(new NvhUsers(1L ,"user1", "pass1", "John Doe",
                LocalDate.parse("1990-01-01"), "john@example.com","1234567890", 34, true));
        nvhUsersList.add(new NvhUsers(2L ,"user2", "pass2", "Jane Smith",
                LocalDate.parse("1990-05-15"), "jane@example.com","0987654321", 32, false));
        nvhUsersList.add(new NvhUsers(3L ,"user3", "pass3", "Alice Johnson",
                LocalDate.parse("1985-11-22"), "alice@example.com","1122334455", 39, true));
        nvhUsersList.add(new NvhUsers(4L ,"user4", "pass4", "Bob Brown",
                LocalDate.parse("1988-03-18"), "bob@example.com","6677889900", 36, true));
        nvhUsersList.add(new NvhUsers(5L ,"user5", "pass5", "Charline White",
                LocalDate.parse("1995-09-30"), "charlie@example.com","4433221100", 29, false));
    }
    public List<NvhUsers> finfAll(){
        return nvhUsersList;
    }

    public Boolean create(NvhUserDTO nvhUserDTO){
        try {
            NvhUsers nvhUsers = new NvhUsers();
            nvhUsers.setNvhId(nvhUsersList.stream().count()+1);
            nvhUsers.setNvhUsername(nvhUserDTO.getNvhUsername());
            nvhUsers.setNvhPassword(nvhUserDTO.getNvhPassword());
            nvhUsers.setNvhEmail(nvhUserDTO.getNvhEmail());
            nvhUsers.setNvhFullname(nvhUserDTO.getNvhFullname());
            nvhUsers.setNvhPhone(nvhUserDTO.getNvhPhone());
            nvhUsers.setNvhAge(nvhUserDTO.getNvhAge());
            nvhUsers.setNvhBirtDay(nvhUserDTO.getNvhBirtDay());
            nvhUsers.setNvhStatus(nvhUserDTO.getNvhStatus());
            nvhUsersList.add(nvhUsers);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
