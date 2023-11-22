package com.ramonwest.groceriesapi.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_storage_areas")
public class UserStorageArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_storage_area_id")
    private Long userStorageAreaId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private StorageArea storageArea;
}
