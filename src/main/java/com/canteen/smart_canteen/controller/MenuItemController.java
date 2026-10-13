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
import org.springframework.web.bind.annotation.RestController;

import com.canteen.smart_canteen.entity.MenuItem;
import com.canteen.smart_canteen.repository.MenuItemRepository;

@RestController
@RequestMapping("/api/menu-items")
@CrossOrigin(origins = "https://ai-smart-college-canteen-frontend.onrender.com")
public class MenuItemController {

    private final MenuItemRepository repository;

    public MenuItemController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MenuItem> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public MenuItem addItem(@RequestBody MenuItem item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public MenuItem updateItem(@PathVariable Long id, @RequestBody MenuItem item) {
        MenuItem existing = repository.findById(id).orElseThrow();

        existing.setName(item.getName());
        existing.setPrice(item.getPrice());
        existing.setAvailable(item.isAvailable());

        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}