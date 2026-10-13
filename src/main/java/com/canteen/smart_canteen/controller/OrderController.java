package com.canteen.smart_canteen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.smart_canteen.entity.Order;
import com.canteen.smart_canteen.entity.OrderStatus;
import com.canteen.smart_canteen.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "https://ai-smart-college-canteen-frontend.onrender.com")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return repository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {

        Order order = repository.findById(id).orElseThrow();
        order.setStatus(status);

        return repository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }
}