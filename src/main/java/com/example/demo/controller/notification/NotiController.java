package com.example.demo.controller.notification;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.service.notification.NotiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noti")
public class NotiController {
    
    @Autowired
    private NotiService notiService;

    @GetMapping
    public BaseResponse getNotifications()
    {
        return notiService.getNotifications();
    }

    @GetMapping("/read/{id}")
    public void readNotification(@PathVariable("id") Integer notiId)
    {
        notiService.readNotification(notiId);
    }

}
