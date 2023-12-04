package com.example.springtest.mockTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public String[] getAllUser() {
        String[] users = userDao.findAllUser();
        setUserUpper(users);

        return users;
    }

    public String[] getUsers() {
        Page users = userDao.findUsers();

        String[] userList = users.getContent();
        setUserUpper(userList);

        return userList;
    }

    public void setUserUpper(String[] users) {
        for (int i = 0; i < users.length; i++) {
            users[i] = users[i].toUpperCase();
        }
    }
}
