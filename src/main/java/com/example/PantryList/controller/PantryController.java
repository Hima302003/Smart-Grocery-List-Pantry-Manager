package com.example.PantryList.controller;

import com.example.PantryList.entity.PantryItem;
import com.example.PantryList.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PantryController {
    @Autowired
    private PantryService pantryService;

    // Add a pantry item
    @PostMapping
    public ResponseEntity<PantryItem> addPantryItem(@RequestBody PantryItem item) {
        PantryItem savedItem = pantryService.addPantryItem(item);
        return ResponseEntity.status(201).body(savedItem);
    }

    // Get all pantry items for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<PantryItem>> getPantryItems(@PathVariable String userId) {
        List<PantryItem> items = pantryService.getPantryItemsByUser(userId);
        return ResponseEntity.ok(items);
    }

    // Get pantry alerts (low stock or expired items)
    @GetMapping("/pantry-alerts/{userId}")
    public ResponseEntity<Map<String, Object>> getPantryAlerts(@PathVariable String userId) {
        List<Map<String, Map<String, String>>> alerts = pantryService.getPantryAlerts(userId).stream()
                .map(alert -> Map.of("message", alert))
                .toList();

        Map<String, Object> response = Map.of(
                "userId", userId,
                "alerts", alerts
        );

        return ResponseEntity.ok(response);
    }
}
