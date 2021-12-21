package com.example.demo.controller.user;

import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/society")
public class SocietyController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<SocietyDTO>addSocietyUser(@RequestBody SocietyDTO societyDTO) {
        if(userService.addSocietyUser(societyDTO))
        {
            return ResponseEntity.ok(societyDTO);
        }
        return null;
    }

}
