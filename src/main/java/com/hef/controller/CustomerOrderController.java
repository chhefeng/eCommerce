package com.hef.controller;

import com.hef.entity.CustomerOrder;
import com.hef.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private OrderService orderService;

    @Autowired
    public CustomerOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("customer/{customerId}/orders")
    public List<CustomerOrder> findAll(@PathVariable Long customerId){
        return orderService.findAllByCustomerId(customerId);
    }

    @GetMapping("customer/{customerId}/order/{orderId}")
    public CustomerOrder findOne (@PathVariable Long customerId, @PathVariable Long orderId){
        return orderService.findById(orderId);
    }

    @PostMapping("customer/{customerId}/order")
    public CustomerOrder save(@PathVariable Long customerId, @RequestBody CustomerOrder customerOrder){
        return orderService.save(customerOrder);
    }


}
