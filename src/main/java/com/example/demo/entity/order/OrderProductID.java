package com.example.demo.entity.order;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductID implements Serializable {
    private static final long serialVersionUID = 2522592972198287466L;

    public int order_id;
    public int product_id;
}
