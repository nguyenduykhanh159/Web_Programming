package com.example.demo.controller.user.impl;

import java.util.List;

import com.example.demo.controller.user.UserController;
import com.example.demo.dto.user.SocietyDTO;
import com.example.demo.service.user.SocietyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/society")
public class SocietyControllerImpl implements UserController<SocietyDTO> {

    @Autowired
    private SocietyService societyService;

    @Override
    public List<SocietyDTO> getAllUsers() {
        
        return societyService.getAll();
    }


    @Override
    public boolean addUser(SocietyDTO userDTO) {
        
        return societyService.addUser(userDTO);
    }


    @Override
    public SocietyDTO getUserById(Integer userId) {
        
        return societyService.getUser(userId);
    }
     @GetMapping("/{societyid}/{farmerid}")
    public boolean addSocietytoFarmer(@PathVariable("societyid") Integer societyid,@PathVariable("farmerid") Integer farmerid)
    {
        return societyService.addSocietyToFarmer(societyid, farmerid);
    }


    @Override
    public boolean removeUser(Integer userid) {
        
        return societyService.removeUser(userid);
    }
}
