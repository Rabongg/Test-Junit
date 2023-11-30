package com.example.springtest.mockTest;

import org.springframework.stereotype.Service;

@Service
public class UserDao {

    public String[] findAllUser() {

        return new String[]{"rabong", "orange"};
    }
}
