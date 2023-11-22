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
            "LEFT JOIN UserStorageArea usa ON u.id = usa.user.id " +
            "LEFT JOIN StorageArea sa ON usa.storageArea.id = sa.id " +
            "LEFT JOIN StorageAreaCategory sac ON sa.id = sac.storageArea.id " +
            "LEFT JOIN Category c ON sac.category.id = c.id " +
            "LEFT JOIN CategoryGroceryItem cgi ON c.id = cgi.category.id " +
            "LEFT JOIN Item item ON cgi.groceryItem.id = item.id " +
            "WHERE u.id = :userId")
    List<StorageArea> getUserGroceries(@Param("userId") Long userId);
}
