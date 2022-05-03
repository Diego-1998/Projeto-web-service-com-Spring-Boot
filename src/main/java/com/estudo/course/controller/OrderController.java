package com.estudo.course.controller;

import com.estudo.course.entities.Order;
import com.estudo.course.entities.User;
import com.estudo.course.services.OrderService;
import com.estudo.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){

        List<Order> order = orderService.findAll();
        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable Long orderId){
        Order obj = orderService.findById(orderId);
        return ResponseEntity.ok().body(obj);
    }

}
