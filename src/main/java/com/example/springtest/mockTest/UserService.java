package com.example.springtest.mockTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public String[] getAllUser() {
        String[] users = userDao.findAllUser();
        for (int i = 0; i < users.length; i++) {
            users[i] = users[i].toUpperCase();
        }
        return users;
    }

    public String[] getUsers() {
        Page users = userDao.findUsers();

        String[] userList = users.getContent();

        for (int i = 0; i < userList.length; i++) {
            userList[i] = userList[i].toUpperCase();
        }
        return userList;
    }
}
