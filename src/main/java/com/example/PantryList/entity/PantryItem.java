package com.example.PantryList.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pantry_items")
public class PantryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String name;
    private int quantity;
    private LocalDate expiryDate;
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
