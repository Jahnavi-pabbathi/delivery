package com.tgt.upcurve.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@Data
@NoArgsConstructor
@Entity
@Table(name="order_delivery")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name="store_id")
    private Integer storeId;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="image_id")
    private Integer imageId;

    @Column(name="payment_status")
    private String paymentStatus;

    @Column(name = "delivery_status")
    private String deliveryStatus;

    @Column(name = "pickup_date")
    private Date pickupDate;

}
