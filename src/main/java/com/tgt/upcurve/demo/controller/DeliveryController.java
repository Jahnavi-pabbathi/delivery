package com.tgt.upcurve.demo.controller;

import com.tgt.upcurve.demo.entity.DeliveryEntity;
import com.tgt.upcurve.demo.service.DeliveryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("delivery_api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/fetch_delivery_by_id/{customer_id}/{order_id}")
    public DeliveryEntity fetchDeliveryByCustomerIdAndOrderId(@Validated @PathVariable("customer_id") Integer customerId, @Validated @PathVariable("order_id") Integer orderId) {
        return deliveryService.fetchDeliveryByCustomerIdAndOrderId(customerId, orderId);

    }

    @GetMapping("/fetch_delivery_by_image_id/{image_id}")
    public List<DeliveryEntity> fetchDeliveryByImageId(@Validated @PathVariable("image_id") Integer imageId) {
        return deliveryService.fetchDeliveryByImageId(imageId);
    }



    @GetMapping("/fetch_delivery_by_customer_id/{customer_id}")
    public List<DeliveryEntity> fetchDeliveryByCustomerId(@Validated @PathVariable("customer_id") Integer customerId) {
        return deliveryService.fetchDeliveryByCustomerId(customerId);
    }

    @GetMapping("/fetch_delivery_details_by_date/{pickup_date}")
public List<DeliveryEntity> getDeliveryDetailsByDate(@DateTimeFormat(pattern = "dd.mm.yyyy") @PathVariable(value = "pickup_date") LocalDate pickupDate) {
        return  deliveryService.getDeliveryDetailsByDate(pickupDate);
    }


    @PostMapping
    public DeliveryEntity saveDelivery(@Validated @RequestBody DeliveryEntity delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @DeleteMapping("/{customer_id}/{order_id}")
    public void deleteOrder(@Validated @PathVariable("customer_id") Integer customerId, @Validated @PathVariable("order_id") Integer orderId) {
        deliveryService.deleteDelivery(customerId, orderId);
    }



}
