package com.ramonwest.groceriesapi.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category_grocery_items")
public class CategoryGroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_grocery_item_id")
    private long categoryGroceryItemId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "grocery_item_id")
    private Item groceryItem;

    public long getCategoryGroceryItemId() {
        return categoryGroceryItemId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item getGroceryItem() {
        return groceryItem;
    }

    public void setGroceryItem(Item groceryItem) {
        this.groceryItem = groceryItem;
    }
}
