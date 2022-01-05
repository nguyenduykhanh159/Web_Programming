package com.example.demo.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderProductDTO {
    @JsonProperty("quantity")
    private int quantity;
}
