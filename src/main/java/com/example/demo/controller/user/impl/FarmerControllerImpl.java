package com.example.demo.controller.user.impl;

import java.util.List;

import com.example.demo.controller.user.UserController;
import com.example.demo.dto.user.FarmerDTO;
import com.example.demo.service.user.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/farmer")
public class FarmerControllerImpl implements UserController<FarmerDTO> {

    @Autowired
    private FarmerService farmerService;

    @Override
    public List<FarmerDTO> getAllUsers() {
        return farmerService.getAll();
    }

    @Override
    public FarmerDTO getUserById(Integer userId) {
        return farmerService.getUser(userId);
    }

    @Override
    public boolean addUser(FarmerDTO userDTO) {
        return farmerService.addUser(userDTO);
    }

    @Override
    public boolean removeUser(Integer userid) {

        return farmerService.removeUser(userid);
    }

    @GetMapping("/{userid}/{societyId}")
    public boolean addFarmerToSociety(@PathVariable("userid") Integer userid,
            @PathVariable("societyId") Integer societyid) {
        return farmerService.addFarmerToSociety(userid, societyid);
    }

}
