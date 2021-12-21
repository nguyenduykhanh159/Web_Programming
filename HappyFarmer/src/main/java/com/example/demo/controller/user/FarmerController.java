package com.example.demo.controller.user;

import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.entity.FarmerSociety;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/farmer")
public class FarmerController {
    @Autowired
    private UserService userService;
    @PostMapping(value = {"","/"})
    public ResponseEntity<FarmerDTO> addFarmerUser(@RequestBody FarmerDTO farmerDTO) {
        if(userService.addFarmerUser(farmerDTO))
        {
            return ResponseEntity.ok(farmerDTO);
        }
        return null;
    }

    // @PostMapping("/farmer/{id}")
    // public ResponseEntity<FarmerSocietyDTO>
}
