package com.example.demo.dto.order;

import java.util.Collection;
import java.util.Date;

import javax.persistence.JoinColumn;

import com.example.demo.dto.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {


    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("products")
    private Collection<OrderProductDTO> products;

    @JsonProperty("total_amount")
    private Float totalAmount;

    @JsonProperty("user")
    private UserDTO user;
}
