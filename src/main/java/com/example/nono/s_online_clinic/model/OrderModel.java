package com.example.nono.s_online_clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Order_id;
    private String orderType;
    private String orderName;
    private String orderDetails;
    private String orderCharge;

    public OrderModel() {
    }

    public OrderModel(Long order_id, String orderType, String orderName, String orderDetails, String orderCharge) {
        Order_id = order_id;
        this.orderType = orderType;
        this.orderName = orderName;
        this.orderDetails = orderDetails;
        this.orderCharge = orderCharge;
    }

    public Long getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Long order_id) {
        Order_id = order_id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderCharge() {
        return orderCharge;
    }

    public void setOrderCharge(String orderCharge) {
        this.orderCharge = orderCharge;
    }
}
