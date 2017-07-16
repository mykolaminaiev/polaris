package com.polaris.common.config.security;

import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii on 07.05.2016.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);
        if (user == null) {
            String message = "Username " + name + " not found";
            logger.info(message);
            throw new UsernameNotFoundException(message);
        }

        logger.info("Found user in database: " + user);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(name, user.getPassword(), authorities);
    }
}
