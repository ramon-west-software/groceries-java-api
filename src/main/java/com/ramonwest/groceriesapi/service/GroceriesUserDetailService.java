package com.ramonwest.groceriesapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface GroceriesUserDetailService extends UserDetailsService {
    UserDetails getUserByUsername(String username) throws UsernameNotFoundException;
    
}
