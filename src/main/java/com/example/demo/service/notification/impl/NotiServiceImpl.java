package com.example.demo.service.notification.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dao.NotificationRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.notification.NotificationDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.notification.NoteStatus;
import com.example.demo.entity.notification.Notification;
import com.example.demo.entity.user.User;
import com.example.demo.service.notification.NotiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotiServiceImpl implements NotiService {

    @Autowired
    private NotificationRepository notiRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNewNotification(Notification noti) {
        try {
            notiRepository.save(noti);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex.getCause());
        }

    }

    @Override
    public BaseResponse getNotifications() {
        try {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            User user = userRepository.findById(userDetails.getUser().getId()).get();

            Collection<Notification> notifications = user.getNotifications();
            List<NotificationDTO> notficationDTOs = new ArrayList<>();
            for (Notification notification : notifications) {
                NotificationDTO notiDTO = new NotificationDTO();
                notiDTO.setCreatedAt(notification.getCreatedAt());
                notiDTO.setMessage(notification.getMessage());
                notiDTO.setSender(notification.getSender());
                notiDTO.setStatus(notification.getStatus().toString());
                notiDTO.setId(notification.getId());
                notficationDTOs.add(notiDTO);

            }
            return new BaseResponse<>(HttpStatus.OK, "All notifications", notficationDTOs);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Request failed!");
        }

    }

    @Override
    public void readNotification(int notiId) {
        try {
            
            Notification noti=notiRepository.findById(notiId).orElse(null);
            noti.setStatus(NoteStatus.READ);
            notiRepository.save(noti);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
        
    }

}
