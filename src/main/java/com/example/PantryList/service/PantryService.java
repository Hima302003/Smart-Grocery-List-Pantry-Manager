package com.example.PantryList.service;

import com.example.PantryList.entity.PantryItem;
import com.example.PantryList.repo.PantryItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PantryService {
    @Autowired
    private PantryItemRepository pantryItemRepository;

    // Add a new pantry item
    public PantryItem addPantryItem(PantryItem item) {
        return pantryItemRepository.save(item);
    }

    // Fetch all pantry items for a user
    public List<PantryItem> getPantryItemsByUser(String userId) {
        return pantryItemRepository.findByUserId(userId);
    }

    // Fetch alerts for low-stock or expired items
    public List<Map<String, String>> getPantryAlerts(String userId) {
        List<PantryItem> items = pantryItemRepository.findByUserId(userId);

        return items.stream()
                .map(item -> {
                    if (item.getQuantity() <= 2) {
                        return Map.of("item", item.getName(), "message", "Running low, consider restocking");
                    } else if (item.getExpiryDate().isBefore(LocalDate.now())) {
                        return Map.of("item", item.getName(), "message", "Expired on " + item.getExpiryDate());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
