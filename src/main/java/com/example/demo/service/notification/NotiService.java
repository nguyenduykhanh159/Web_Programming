package com.example.demo.service.notification;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.entity.notification.Notification;

public interface NotiService {
    void addNewNotification(Notification noti);
    void readNotification(int notiId);
    BaseResponse getNotifications();
}
