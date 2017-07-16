package com.polaris.common.service.impl;

import com.polaris.common.AbstractTestMongo;
import com.polaris.common.repository.UserRepository;
import com.polaris.common.service.UserService;
import com.polaris.persistence.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mykola_Minaiev
 */
public class UserServiceImplTest extends AbstractTestMongo {

    private static final String COLLECTION_NAME = "user";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private List<User> users = new ArrayList<>();
    private User userOne;
    private User userTwo;

    private User prepareUser(String id, String name, String password, String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    @Before
    public void setUp() {
        userOne = prepareUser("1", "firstUser", "firstUser", "firstMail");
        userTwo = prepareUser("2", "secondUser", "secondUser", "secondMail");
        users.add(userOne);
        users.add(userTwo);
        userRepository.save(userOne);
        userRepository.save(userTwo);
    }

    @After
    public void tearDown() {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

    @Test
    public void listUsers() throws Exception {
        List<User> users = (List<User>) userService.listUsers();
        assertEquals(this.users.size(), users.size());
    }

    @Test
    public void findById() throws Exception {
        User user = userService.findById("1");
        assertEquals(userOne.getName(), user.getName());
        assertEquals(userOne.getPassword(), user.getPassword());
    }

    @Test
    public void findByName() throws Exception {
        User user = userService.findByName("secondUser");
        assertEquals(userTwo.getName(), user.getName());
        assertEquals(userTwo.getPassword(), user.getPassword());
    }

    @Test
    public void updateUser() throws Exception {
        userOne.setName("updatedFirstUser");
        userOne.setPassword("updatedFirstUser");
        User user = userService.updateUser(userOne);
        assertEquals(userOne.getId(), user.getId());
        assertEquals(userOne.getName(), user.getName());
        assertEquals(userOne.getPassword(), user.getPassword());
    }

}