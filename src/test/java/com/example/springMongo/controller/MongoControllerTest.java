package com.example.springMongo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.springMongo.model.User;
import com.example.springMongo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MongoControllerTest {
    @InjectMocks
    MongoController mongoController;
    @Mock
    UserRepository userRepository;

    @Test
    public void testFindAllUsers()
    {
        User user1 = new User("Saurabh", "sharma", "08091989", "Mr");
        User user2 = new User("Sumit", "Alex", "19111987", "Dr.");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        when(userRepository.findByTitle(any())).thenReturn(users);
        ResponseEntity<List<User>> userRes = mongoController.getAllUsers("");
        assertThat(userRes.getBody().size()).isEqualTo(2);
        assertThat(userRes.getBody().get(0).getFirstName()).isEqualTo("Saurabh");

    }

    @Test
    public void testCreateUsers()
    {
        User user1 = new User("Saurabh", "sharma", "08091989", "Mr");
        when(userRepository.save(any())).thenReturn(user1);
        ResponseEntity<User> userRes = mongoController.createUser(user1);
        assertThat(userRes.getBody().getFirstName()).isEqualTo("Saurabh");
    }

    @Test
    public void testUpdateUsers()
    {
        User user1 = new User("Saurabh", "sharma", "08091989", "Mr");
        when(userRepository.findById(any())).thenReturn(java.util.Optional.of(user1));
        when(userRepository.save(any())).thenReturn(user1);
        ResponseEntity<User> userRes = mongoController.updateUsers("123",user1);
        assertThat(userRes.getBody().getFirstName()).isEqualTo("Saurabh");
    }

}


