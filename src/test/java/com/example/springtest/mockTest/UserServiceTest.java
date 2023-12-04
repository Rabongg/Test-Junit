package com.example.springtest.mockTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Spy
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
    @Test
    void getUsersTest() {

        Page mockUsers = mock(Page.class); // interface를 mocking
        String[] users = {"rabong", "apple"};
        when(userDao.findUsers()).thenReturn(mockUsers);
        when(mockUsers.getContent()).thenReturn(users); // mock한 interface stubbing
        doNothing().when(subject).setUserUpper(users);  // 내부 메서드 stubbing

        String[] result = subject.getUsers();

        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals("rabong", result[0]);
        Assertions.assertEquals("apple", result[1]);
    }

    @Test
    void setUserUpperTest() {
        String[] users = {"rabong", "apple"};

        subject.setUserUpper(users);

        Assertions.assertEquals("RABONG", users[0]);
        Assertions.assertEquals("APPLE", users[1]);
    }
}
