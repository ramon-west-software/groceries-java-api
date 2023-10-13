package com.ramonwest.groceriesapi.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "storage_area_categories")
public class StorageAreaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_storage_id")
    private Long userStorageAreaId;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private StorageArea storageArea;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getUserStorageAreaId() {
        return userStorageAreaId;
    }

    public StorageArea getStorageArea() {
        return storageArea;
    }

    public void setStorageArea(StorageArea storageArea) {
        this.storageArea = storageArea;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
