package com.example.springtest.mockTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService subject;

    @Test
    void getAllUserTest() {
        String[] users = {"rabong", "apple"};

        when(userDao.findAllUser()).thenReturn(users);  // userDao stubbing

        String[] result = subject.getAllUser();

        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals("RABONG", result[0]);
        Assertions.assertEquals("APPLE", result[1]);
    }
}