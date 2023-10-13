package com.ramonwest.groceriesapi.service;

import com.ramonwest.groceriesapi.data.entity.StorageArea;
import com.ramonwest.groceriesapi.data.entity.User;
import com.ramonwest.groceriesapi.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(long id) {
        User user = userRepository.findById(id)
                .orElse(null);

        try {
            assert user != null;
            user.setstorageAreas(getStorageAreasByUserId(id));
        } catch(Exception e) {
            System.out.println("Failed to query user storage areas. " + e);
            return new User();
        }

        return user;
    }

    @Override
    public void addUser(User user) {
        System.out.print("New user created! " + user.toString());
    }
    private List<StorageArea> getStorageAreasByUserId(Long userId) {

        List<StorageArea> storageAreas = userRepository.getUserGroceries(userId);

        if (storageAreas != null) {
            return storageAreas;
        } else {
            return new ArrayList<>();
        }
    }

}
