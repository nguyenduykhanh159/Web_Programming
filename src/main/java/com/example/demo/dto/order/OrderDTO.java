package com.example.demo.dto.order;

import java.util.Collection;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderDTO {


    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("products")
    private Collection<OrderProductDTO> products;
}
