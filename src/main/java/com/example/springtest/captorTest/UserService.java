package com.example.springtest.captorTest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void deleteUser(User user) {
        user.setState("DELETED");
        userDao.saveUser(user);
    }

    public void createUser(User user) {
        user.setState("CREATED");
        userDao.saveUser(user);
    }
}
