package com.ramonwest.groceriesapi.data.repository;

import com.ramonwest.groceriesapi.data.entity.StorageArea;
import com.ramonwest.groceriesapi.data.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "User.storageAreas", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT sa " +
            "FROM User u " +
            "LEFT JOIN UserStorageArea usa ON u.userId = usa.user.userId " +
            "LEFT JOIN StorageArea sa ON usa.storageArea.storageId = sa.storageId " +
            "LEFT JOIN StorageAreaCategory sac ON sa.storageId = sac.storageArea.storageId " +
            "LEFT JOIN Category c ON sac.category.categoryId = c.categoryId " +
            "LEFT JOIN CategoryGroceryItem cgi ON c.categoryId = cgi.category.categoryId " +
            "LEFT JOIN Item item ON cgi.groceryItem.itemId = item.itemId " +
            "WHERE u.userId = :userId")
    List<StorageArea> getUserGroceries(@Param("userId") Long userId);
}
