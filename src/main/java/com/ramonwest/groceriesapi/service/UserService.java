package com.ramonwest.groceriesapi.service;

import com.ramonwest.groceriesapi.data.entity.User;

public interface UserService {
    public User getUser(long id);
    public void addUser(User user);
}
