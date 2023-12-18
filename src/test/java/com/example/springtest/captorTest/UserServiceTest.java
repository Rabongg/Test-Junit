package com.example.springtest.captorTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService subject;

    @Captor
    ArgumentCaptor<User> userArgumentCaptor;

    @Test
    void testDeleteUser() {
        User user = new User("rabong", "CREATED");

        subject.deleteUser(user);

        verify(userDao, times(1)).saveUser(userArgumentCaptor.capture());

        User value = userArgumentCaptor.getValue();
        assertEquals("DELETED", value.getState());
    }

    @Test
    void testCreateUser() {
        User user = new User("rabong", "CREATING");

        subject.createUser(user);

        ArgumentCaptor<User> userArgumentCaptor1 = ArgumentCaptor.forClass(User.class);
        verify(userDao, times(1)).saveUser(userArgumentCaptor1.capture());
        User value = userArgumentCaptor1.getValue();
        assertEquals("CREATED", value.getState());
    }
}