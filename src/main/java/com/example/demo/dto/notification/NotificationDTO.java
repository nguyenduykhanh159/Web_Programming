package com.example.demo.dto.notification;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDTO {

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("sender")
    private String sender;

    @JsonProperty("message")
    private String message;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("status")
    private String status;
    
}
