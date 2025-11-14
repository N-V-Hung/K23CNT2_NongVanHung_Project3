package com.devmaster.K23CNt2.nvhDay04.nvhController;


import com.devmaster.K23CNt2.nvhDay04.nvhDto.NvhUserDTO;
import com.devmaster.K23CNt2.nvhDay04.nvhEntity.NvhUsers;
import com.devmaster.K23CNt2.nvhDay04.nvhService.NvhUsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class NvhUsersController {

    @Autowired
    NvhUsersService nvhUsersService;

    @GetMapping("/user-list")
    public List<NvhUsers> nvhGetAllUsers(){
        return nvhUsersService.finfAll();
    }

    @PostMapping("/user-add")
    public ResponseEntity<String> nvhAddUser(@Valid @RequestBody NvhUserDTO nvhUserDTO) {
        boolean created = nvhUsersService.create(nvhUserDTO);
        if (created) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to create user");
        }
    }
}
