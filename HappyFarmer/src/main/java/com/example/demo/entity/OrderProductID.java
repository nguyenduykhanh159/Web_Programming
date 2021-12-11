package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductID implements Serializable {
    private static final long serialVersionUID = 2522592972198287466L;

    public int order_id;
    public int product_id;
}
