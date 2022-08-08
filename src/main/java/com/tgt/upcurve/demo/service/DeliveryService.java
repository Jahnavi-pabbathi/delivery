package com.tgt.upcurve.demo.service;

import com.tgt.upcurve.demo.entity.DeliveryEntity;
import com.tgt.upcurve.demo.repository.DeliveryRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@Service
public class DeliveryService{

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryEntity fetchDeliveryByCustomerIdAndOrderId(Integer customerId, Integer orderId) {
        return deliveryRepository.findDeliveryByCustomerIdAndOrderId(customerId, orderId);
    }

    public List<DeliveryEntity> fetchDeliveryByCustomerId(Integer customerId) {
        return deliveryRepository.findAllByCustomerId(customerId);
    }

    public DeliveryEntity saveDelivery(DeliveryEntity delivery) {
        DeliveryEntity saveDelivery = null;
        DeliveryEntity existingOrder = deliveryRepository.findDeliveryByCustomerIdAndOrderId(delivery.getCustomerId(), delivery.getOrderId());
        if(null == existingOrder){
            saveDelivery = deliveryRepository.save(delivery);
        }
        return saveDelivery;
    }

    public List<DeliveryEntity> getDeliveryDetailsByDate(LocalDate pickupDate) {
        return deliveryRepository.findAllByPickupDate(pickupDate);
    }

    public List<DeliveryEntity> fetchDeliveryByImageId(Integer imageId) {
        return deliveryRepository.findAllByImageId(imageId);
    }

    public void deleteDelivery(Integer customerId, Integer orderId) {
        DeliveryEntity existingDelivery = deliveryRepository.findDeliveryByCustomerIdAndOrderId(customerId, orderId);
        if(null != existingDelivery){
            deliveryRepository.delete(existingDelivery);
        }
    }


}
