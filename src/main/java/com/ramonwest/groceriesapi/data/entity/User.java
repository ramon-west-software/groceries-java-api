package com.ramonwest.groceriesapi.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NamedEntityGraph(name = "User.storageAreas", attributeNodes = {
        @NamedAttributeNode(value = "storageAreas", subgraph = "storageAreasGraph")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_storage_areas",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "storage_id")
    )
    private List<StorageArea> storageAreas = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<StorageArea> getstorageAreas() {
        return storageAreas;
    }

    public void setstorageAreas(List<StorageArea> storageAreas) {
        this.storageAreas = storageAreas;
    }
}
